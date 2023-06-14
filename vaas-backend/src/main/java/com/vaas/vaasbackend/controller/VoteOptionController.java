package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblVoteOption;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.responseBody.TotalVoteForIssue;
import com.vaas.vaasbackend.service.VoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VoteOptionController {
    @Autowired
    VoteOptionService voteOptionService;

    @GetMapping("/voteoption")
    public List<TblVoteOption> showVoteOption() throws DataNotFoundException {
        return voteOptionService.showVoteOption();
    }

    @PostMapping("/voteoption")
    public TblVoteOption saveVoteOption(@RequestBody TblVoteOption tblVoteOption) throws Exception {
        return voteOptionService.saveVoteOption(tblVoteOption);
    }

    @GetMapping("/voteoption/findtotalvote/{issueId}/{roundNumber}")
    public List<TotalVoteForIssue> countTotalVotes(@PathVariable(name = "issueId") Integer issueId,@PathVariable(name = "roundNumber") Integer roundNumber) throws DataNotFoundException {
        return voteOptionService.countTotalVotes(issueId,roundNumber);
    }

    @GetMapping("/voteoption/getUserOptionList/{issueId}/{roundNumber}/{userId}")
    public List<TotalVoteForIssue> getUserOptionList(@PathVariable(name = "issueId") Integer issueId,@PathVariable(name = "roundNumber") Integer roundNumber,@PathVariable(name = "userId") Integer userId) throws DataNotFoundException {
        return voteOptionService.getUserOptionList(issueId,roundNumber,userId);
    }
}
