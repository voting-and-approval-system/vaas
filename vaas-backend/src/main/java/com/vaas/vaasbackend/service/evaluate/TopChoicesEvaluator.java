package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class TopChoicesEvaluator implements Evaluator{
    @Override
    public boolean isSupported(String votingType) {
        return "top-choices".equalsIgnoreCase(votingType);
    }

    @Override
    public List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> optionList) {
        Collections.sort(optionList, new Comparator<TotalVoteForIssue>() {
            @Override
            public int compare(TotalVoteForIssue o1, TotalVoteForIssue o2) {
                return Integer.compare(o2.getCount(), o1.getCount());
            }
        });

        List<TotalVoteForIssue> totalVoteForIssues = new ArrayList<>();
        for (int i = 0; i < 3 && i < optionList.size(); i++) {
            totalVoteForIssues.add(optionList.get(i));
        }
        return totalVoteForIssues;
    }
}
