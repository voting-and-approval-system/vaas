package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.repository.VoteOptionRepository;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.IssueService;
import com.vaas.vaasbackend.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class InstantRunoffEvaluator implements Evaluator {
    @Autowired
    IssueService issueService;
    @Autowired
    OptionService optionService;
    @Autowired
    VoteOptionRepository voteOptionRepository;

    private int requireVote, preference, issueId, roundNo;

    @Override
    public boolean isSupported(String votingType) {
        return "Instant-runoff".equalsIgnoreCase(votingType);
    }

    @Override
    public List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> optionList) throws DataNotFoundException {
        preference = 1;

        TblOption option = optionService.showOption(optionList.get(0).getOptionId());
        TblIssue issue = option.getIssue();
        roundNo = optionList.get(0).getRoundNumber();
        issueId = issueService.showIssue(issue.getId()).getId();
        int totalVote = voteOptionRepository.totalVote(issueId,roundNo);
        requireVote = totalVote * 50 / 100;

        List<TotalVoteForIssue> firstPreferenceOptionList = optionList.stream().filter(list -> list.getPreference() == 1).collect(Collectors.toCollection(ArrayList<TotalVoteForIssue>::new));

        return eliminateLeastCountOption(firstPreferenceOptionList);
    }

    private List<TotalVoteForIssue> eliminateLeastCountOption(List<TotalVoteForIssue> firstPreferenceOptionList) throws DataNotFoundException {
        List<TotalVoteForIssue> returnList = new ArrayList<>();
        TotalVoteForIssue optionWithMaxCount = null;
        int highestCount = 0;
        for (TotalVoteForIssue TotalVoteForIssue : firstPreferenceOptionList) {
            if (TotalVoteForIssue.getCount() > highestCount) {
                highestCount = TotalVoteForIssue.getCount();
                optionWithMaxCount = TotalVoteForIssue;
            }
        }

        if (optionWithMaxCount.getCount() > requireVote) {
            returnList.add(optionWithMaxCount);
        } else {
            if (firstPreferenceOptionList.size() > 1) {
                preference++;
                TotalVoteForIssue optionWithMinCount = null;
                int lowestCount = firstPreferenceOptionList.get(0).getCount();
                for (TotalVoteForIssue TotalVoteForIssue : firstPreferenceOptionList) {
                    if (TotalVoteForIssue.getCount() < lowestCount) {
                        lowestCount = TotalVoteForIssue.getCount();
                        optionWithMinCount = TotalVoteForIssue;
                    }
                }

                int optionId = optionWithMinCount.getOptionId();
                int users[] = voteOptionRepository.userVoteForLeastOption(optionId);
                List<TotalVoteForIssue> newOptionList = voteOptionRepository.getNextPreferenceOfLeastOptionUser(preference, issueId,roundNo ,Arrays.stream(users).toArray());
                if (newOptionList.isEmpty()) {
                    if (preference == 1) {
                        throw new DataNotFoundException("No Data Found");
                    }
                }
                firstPreferenceOptionList.remove(optionWithMinCount);

                for (TotalVoteForIssue newOption : newOptionList) {
                    int optionIdOfNewOption = newOption.getOptionId();
                    Optional<TotalVoteForIssue> existingOption = firstPreferenceOptionList.stream()
                            .filter(o -> o.getOptionId() == optionIdOfNewOption)
                            .findFirst();
                    if (existingOption.isPresent()) {
                        TotalVoteForIssue optionToUpdate = existingOption.get();
                        optionToUpdate.setCount(optionToUpdate.getCount() + newOption.getCount());
                    }
                }
                return eliminateLeastCountOption(firstPreferenceOptionList);
            }
        }
        return returnList;
    }
}
