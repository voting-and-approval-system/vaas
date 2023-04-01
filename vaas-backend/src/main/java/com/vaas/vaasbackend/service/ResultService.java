package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.evaluate.Evaluator;
import com.vaas.vaasbackend.service.evaluate.MaxVoteEvaluator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ResultService {
    MaxVoteEvaluator evalImpl;
    Evaluator.Result getResult(int issueId) {
        // TODO: prefetch issue config etc.

        //TODO: iterate over all impl of Evaluator
        // for(evalImpl of ...) // use get beans from spring
        // evalImpl.evaluate(issueId);
        return null;
    }

    public List<TotalVoteForIssue> getResponseListFromApi(Integer issueId,Integer roundNum) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/voteoption/findtotalvote/" + issueId + "/" + roundNum;
        ResponseEntity<List<TotalVoteForIssue>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TotalVoteForIssue>>() {
                });
        List<TotalVoteForIssue> responseList = responseEntity.getBody();
        return responseList;
    }
}
