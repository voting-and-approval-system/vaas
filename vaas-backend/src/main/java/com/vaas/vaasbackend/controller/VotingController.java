package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.responseBody.Voting;
import com.vaas.vaasbackend.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotingController {

    @Autowired
    VotingService votingService;
    @PostMapping("/voting")
    @CrossOrigin(origins = "http://localhost:4200")
    public Voting insertVotingDetails(@RequestBody Voting voting) throws Exception {
        return votingService.insertVotingDetails(voting);
    }
}
