package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.UserVoteService;
import com.vaas.vaasbackend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class TopChoicesEvaluator implements Evaluator{
    @Autowired
    UsersService usersService;
    @Autowired
    UserVoteService userVoteService;
    @Override
    public boolean isSupported(String votingType) {
        return "top-choices".equalsIgnoreCase(votingType);
    }

    @Override
    public boolean resultValidation(int issueId, int roundNumber) {
        boolean valid = false;
        int totalVote = usersService.totalUser();
        int totalVoteForRound = userVoteService.countVoteForRound(issueId,roundNumber);

        float percentage =  ((float) totalVoteForRound /(float) totalVote) * 100;

        if(percentage >= 30) {
            valid = true;
        }
        return valid;
    }
    @Override
    public List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> optionList) throws Exception {
        Collections.sort(optionList, new Comparator<TotalVoteForIssue>() {
            @Override
            public int compare(TotalVoteForIssue o1, TotalVoteForIssue o2) {
                return Integer.compare(o2.getCount(), o1.getCount());
            }
        });

        List<TotalVoteForIssue> totalVoteForIssues = new ArrayList<>();
        int highestCount = 0;

        for (int i = 0; i < optionList.size(); i++) {
            TotalVoteForIssue option = optionList.get(i);
            if (i < 3) {
                totalVoteForIssues.add(option);
                highestCount = option.getCount();
            } else if (option.getCount() == highestCount) {
                throw new Exception("An object below the third position has the same count as the third object");
            } else {
                break;
            }
        }
        return totalVoteForIssues;
    }
}
