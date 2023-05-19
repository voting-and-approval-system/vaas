package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoundController {
    @Autowired
    RoundService roundService;
    @GetMapping("/round")
    public List<TblRound> showRound(){
        return roundService.showRound();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/round/{id}")
    public TblRound showRound(@PathVariable Integer id) throws DataNotFoundException {
        return roundService.showRound(id);
    }

    @PostMapping("/round")
    public TblRound saveRound(@RequestBody TblRound round){
        return roundService.saveRound(round);
    }

    @GetMapping("/round/issue/{id}")
    public List<TblRound> showRoundByIssueId(@PathVariable Integer id){
        return roundService.showRoundByIssueId(id);
    }

    @GetMapping("/round/user/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<TblRound> roundUserNotVote(@PathVariable Integer id) throws DataNotFoundException {
        return roundService.roundUserNotVote(id);
    }
}
