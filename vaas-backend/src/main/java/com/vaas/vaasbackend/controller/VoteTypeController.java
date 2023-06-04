package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.entity.TblVotesType;

import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.VoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VoteTypeController {

    @Autowired
    private VoteTypeService voteTypeService;

    @PostMapping("/votetype")
    public TblVotesType saveVoteType(@RequestBody TblVotesType votesType) {
        return voteTypeService.saveVoteType(votesType);
    }

    @GetMapping("/votetype")
    public List<TblVotesType> showVoteType(){
        return voteTypeService.showUserVoteType();
    }

    @GetMapping("/votetype/{id}")
    public TblVotesType showVoteType(@PathVariable Integer id) throws DataNotFoundException {
        return voteTypeService.showVoteType(id);
    }

    @DeleteMapping("/votetype/{id}")
    public String deleteVoteTypeById(@PathVariable("id") Integer id) {
        voteTypeService.deleteVoteTypeById(id);
        return "users deleted Successfully!!";
    }

    @PutMapping("/votetypes/{id}")
    public TblVotesType updateVoteType(@PathVariable("id") Integer id, @Valid @RequestBody TblVotesType votesType) {
        return voteTypeService.updateVoteType(id,votesType);
    }
}
