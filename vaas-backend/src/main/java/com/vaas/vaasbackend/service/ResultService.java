package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.evaluate.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    @Autowired
    VoteOptionService voteOptionService;
    @Autowired
    Evaluator[] evaluatorServices;
    public List<TotalVoteForIssue> getResult(int issueId, int roundNo) throws Exception {
        List<TotalVoteForIssue> responseList = voteOptionService.countTotalVotes(issueId, roundNo);
        TotalVoteForIssue totalVoteForIssue = responseList.get(0);
        String voteType = totalVoteForIssue.getVoteType();
        Optional<Evaluator> voteEvaluatorService = getEvaluatorService(voteType);

        if(voteEvaluatorService.isEmpty()) throw new UnsupportedOperationException("vote type is not supported !!");

        return voteEvaluatorService.get().evaluate(responseList);
    }

    private Optional<Evaluator> getEvaluatorService(String voteType) {
        return Arrays.stream(evaluatorServices).filter(service -> service.isSupported(voteType)).findFirst();
    }
}
