package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class MaxVoteEvaluator implements Evaluator {
    @Override
    public boolean isSupported(String votingType) {
        return "simpleMax".equalsIgnoreCase(votingType);
        //return Collections.emptyList().contains(votingType);
    }

    @Override
    public TotalVoteForIssue evaluate(List<TotalVoteForIssue> responseList) {
        TotalVoteForIssue highestCountObject = null;
        int highestCount = 0;
        for (TotalVoteForIssue TotalVoteForIssue : responseList) {
            if (TotalVoteForIssue.getCount() > highestCount) {
                highestCount = TotalVoteForIssue.getCount();
                highestCountObject = TotalVoteForIssue;
            }
        }
        return highestCountObject;
    }
}

