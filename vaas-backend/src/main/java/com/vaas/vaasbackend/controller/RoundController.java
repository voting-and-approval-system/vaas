package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblRound;
import com.vaas.vaasbackend.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoundController {
    @Autowired
    RoundService roundService;
    @GetMapping("/round")
    public List<TblRound> ShowRound(){
        return roundService.ShowRound();
    }

    @PostMapping("/round")
    public TblRound SaveRound(@RequestBody TblRound round){
        return roundService.SaveRound(round);
    }

    @GetMapping("/round/issue/{id}")
    public List<TblRound> ShowRoundByIssueId(@PathVariable Integer id){
        return roundService.ShowRoundByIssueId(id);
    }
}
