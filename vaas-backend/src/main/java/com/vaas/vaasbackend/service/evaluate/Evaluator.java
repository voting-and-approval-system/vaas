package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import java.util.List;

public interface Evaluator {
    boolean isSupported(String votingType);
    List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> optionList);

    public static class Result {
        /* TODO */
    }
}
