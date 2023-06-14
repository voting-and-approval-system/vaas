package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.ResultService;
import com.vaas.vaasbackend.service.evaluate.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    ResultService resultService;
    @Autowired
    Evaluator[] evaluator;

    @GetMapping("/result/{issueid}/{roundno}")
    public List<TotalVoteForIssue> getResponseWithHighestCount(@PathVariable(name = "issueid") Integer issueId, @PathVariable(name="roundno") Integer roundNo) throws Exception {
        return resultService.getResult(issueId, roundNo);
    }
}
