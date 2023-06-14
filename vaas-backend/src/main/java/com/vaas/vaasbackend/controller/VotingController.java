package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.responseBody.Voting;
import com.vaas.vaasbackend.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VotingController {

    @Autowired
    VotingService votingService;

    @PreAuthorize("hasRole('ROLE_Tenant')")
    @PostMapping("/voting")
    public Voting insertVotingDetails(@RequestBody Voting voting) throws Exception {
        return votingService.insertVotingDetails(voting);
    }
}
