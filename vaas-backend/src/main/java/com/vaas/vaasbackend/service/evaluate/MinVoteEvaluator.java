package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MinVoteEvaluator implements Evaluator{
    @Override
    public boolean isSupported(String votingType) {
        return "simple".equalsIgnoreCase(votingType);
    }

    @Override
    public TotalVoteForIssue evaluate(List<TotalVoteForIssue> responseList) {
        TotalVoteForIssue lowestCountObject = null;
        int lowestCount = responseList.get(1).getCount();
        for (TotalVoteForIssue TotalVoteForIssue : responseList) {
            if (TotalVoteForIssue.getCount() < lowestCount) {
                lowestCount = TotalVoteForIssue.getCount();
                lowestCountObject = TotalVoteForIssue;
            }
        }
        return lowestCountObject;
    }
}
