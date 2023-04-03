package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MinVoteEvaluator implements Evaluator{
    @Override
    public boolean isSupported(String votingType) {
        return "simpleMin".equalsIgnoreCase(votingType);
    }

    @Override
    public List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> responseList) {
        TotalVoteForIssue lowestCountObject = null;
        List<TotalVoteForIssue> totalVoteForIssues = new ArrayList<>();
        int lowestCount = responseList.get(1).getCount();
        for (TotalVoteForIssue TotalVoteForIssue : responseList) {
            if (TotalVoteForIssue.getCount() < lowestCount) {
                lowestCount = TotalVoteForIssue.getCount();
                lowestCountObject = TotalVoteForIssue;
            }
        }
        totalVoteForIssues.add(lowestCountObject);
        return totalVoteForIssues;
    }
}
