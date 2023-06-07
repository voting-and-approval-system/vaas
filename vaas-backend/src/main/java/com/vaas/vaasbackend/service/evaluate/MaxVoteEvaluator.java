package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.UserVoteService;
import com.vaas.vaasbackend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MaxVoteEvaluator implements Evaluator {
    @Autowired
    UsersService usersService;

    @Autowired
    UserVoteService userVoteService;
    @Override
    public boolean isSupported(String votingType) {
        return "simple".equalsIgnoreCase(votingType);
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
    public List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> responseList) throws Exception {
        TotalVoteForIssue highestCountObject = null;
        List<TotalVoteForIssue> totalVoteForIssues = new ArrayList<>();
        int highestCount = 0;
        for (TotalVoteForIssue TotalVoteForIssue : responseList) {
            if (TotalVoteForIssue.getCount() >= highestCount) {
                highestCount = TotalVoteForIssue.getCount();
                highestCountObject = TotalVoteForIssue;
                totalVoteForIssues.add(highestCountObject);
            }
        }
        if(totalVoteForIssues.size() > 1){
            throw new Exception("There Is clash between two options");
        }
        return totalVoteForIssues;
    }
}

