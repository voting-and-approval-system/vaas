package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.ResultService;
import com.vaas.vaasbackend.service.evaluate.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ResultController {
    @Autowired
    ResultService resultService;
    @Autowired
    Evaluator[] evaluator;

    @GetMapping("/result/{issueid}/{roundno}")
    public List<TotalVoteForIssue> getResponseWithHighestCount(@PathVariable(name = "issueid") Integer issueId, @PathVariable(name="roundno") Integer roundNo) {
        //validate input i.e. issueId
        //call ResultService.getResult(issueId);

        List<TotalVoteForIssue> responseList = resultService.getResponseListFromApi(issueId,roundNo);
        TotalVoteForIssue totalVoteForIssue = responseList.get(1);

        String voteType = totalVoteForIssue.getVoteType();

        for (Evaluator e : evaluator) {
            if (e.isSupported(voteType)) {
                return e.evaluate(responseList);
            }
        }
        return null;
    }
}
