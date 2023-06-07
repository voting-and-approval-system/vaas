package com.vaas.vaasbackend.service.evaluate;

import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;

import java.util.List;

public interface Evaluator {
    boolean isSupported(String votingType);
    boolean resultValidation(int issueId,int roundNumber);
    List<TotalVoteForIssue> evaluate(List<TotalVoteForIssue> optionList) throws Exception;
}
