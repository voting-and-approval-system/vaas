package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.evaluate.Evaluator;
import com.vaas.vaasbackend.service.evaluate.MaxVoteEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    MaxVoteEvaluator evalImpl;

    @Autowired
    VoteOptionService voteOptionService;

    @Autowired
    Evaluator[] evaluatorServices;

    public List<TotalVoteForIssue> getResult(int issueId, int roundNo) {
        List<TotalVoteForIssue> responseList = voteOptionService.countTotalVotes(issueId, roundNo);

        TotalVoteForIssue totalVoteForIssue = responseList.get(0);

        String voteType = totalVoteForIssue.getVoteType();

        Optional<Evaluator> voteEvaluatorService = getEvaluatorService(voteType);

        if(voteEvaluatorService.isEmpty()) throw new UnsupportedOperationException("votetypeisnotsuported");

        return voteEvaluatorService.get().evaluate(responseList);
    }

    private Optional<Evaluator> getEvaluatorService(String voteType) {
        return Arrays.stream(evaluatorServices).filter(service -> service.isSupported(voteType)).findFirst();
    }
}
