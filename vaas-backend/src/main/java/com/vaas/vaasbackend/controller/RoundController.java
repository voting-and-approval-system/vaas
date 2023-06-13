package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.entity.TblRole;
import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoundController {
    @Autowired
    RoundService roundService;

    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/round")
    public List<TblRound> showRound(){
        return roundService.showRound();
    }

    @GetMapping("/round/{id}")
    public TblRound showRound(@PathVariable Integer id) throws DataNotFoundException {
        return roundService.showRound(id);
    }

    @PostMapping("/round")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public TblRound saveRound(@RequestBody TblRound round){
        return roundService.saveRound(round);
    }

    @GetMapping("/round/issue/{id}")
    public List<TblRound> showRoundByIssueId(@PathVariable Integer id){
        return roundService.showRoundByIssueId(id);
    }

    @GetMapping("/round/user/{id}")
    public List<TblRound> roundUserNotVote(@PathVariable Integer id) throws DataNotFoundException {
        return roundService.roundUserNotVote(id);
    }

    @GetMapping("/round/uservote/{id}")
    public List<TblRound> roundUserVote(@PathVariable Integer id) throws DataNotFoundException {
        return roundService.roundUserVote(id);
    }

    @GetMapping("/round/issueIsNotActive")
    public List<TblRound> roundWithDeactiveIssues() throws DataNotFoundException {
        return roundService.roundWithDeactiveIssues();
    }

    @GetMapping("/round/deactive")
    public List<TblRound> deactiveRounds() throws DataNotFoundException {
        return roundService.deactiveRounds();
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/round/active")
    public List<TblRound> activeRound() throws DataNotFoundException {
        return roundService.activeRounds();
    }

    @PutMapping("round/{id}/{isActive}")
    public TblRound updateRoundIsActive(@PathVariable("id") Integer roundId, @PathVariable("isActive") boolean isActive) throws DataNotFoundException {
        return roundService.updateRoundIsActive(roundId, isActive);
    }

    @GetMapping("/round/lastRoundNumber/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public Integer lastRoundNumber(@PathVariable("id") int issueId){
        return roundService.lastRoundNumber(issueId);
    }
}
