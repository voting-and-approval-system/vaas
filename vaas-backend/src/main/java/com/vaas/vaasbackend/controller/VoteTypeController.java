package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.entity.TblUsersVote;
import com.vaas.vaasbackend.entity.TblVotesType;
import com.vaas.vaasbackend.service.UserVoteService;
import com.vaas.vaasbackend.service.VoteTypeService;
import com.vaas.vaasbackend.service.VoteTypeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteTypeController {

    @Autowired
    private VoteTypeService voteTypeService;

    @PostMapping("/votetypes")
    public TblVotesType saveVoteType(@RequestBody TblVotesType votesType) {
        return voteTypeService.saveVoteType(votesType);
    }

    @GetMapping("/votetypes")
    public List<TblVotesType> showUserVoteType(){
        return voteTypeService.showUserVoteType();
    }

    @DeleteMapping("/votetypes/{id}")
    public String deleteVoteTypeById(@PathVariable("id") Integer id) {
        voteTypeService.deleteVoteTypeById(id);
        return "users deleted Successfully!!";
    }

    @PutMapping("/votetypes/{id}")
    public TblVotesType updateVoteType(@PathVariable("id") Integer id, @Valid @RequestBody TblVotesType votesType) {
        return voteTypeService.updateVoteType(id,votesType);
    }
}
