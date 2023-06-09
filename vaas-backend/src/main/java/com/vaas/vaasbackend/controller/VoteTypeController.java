package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblAsset;
import com.vaas.vaasbackend.entity.TblVotesType;

import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.VoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VoteTypeController {

    @Autowired
    private VoteTypeService voteTypeService;
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PostMapping("/votetype")
    public TblVotesType saveVoteType(@RequestBody TblVotesType votesType) {
        return voteTypeService.saveVoteType(votesType);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/votetype")
    public List<TblVotesType> showVoteType(){
        return voteTypeService.showUserVoteType();
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/votetype/{id}")
    public TblVotesType showVoteType(@PathVariable Integer id) throws DataNotFoundException {
        return voteTypeService.showVoteType(id);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/votetype/{id}")
    public String deleteVoteTypeById(@PathVariable("id") Integer id) {
        voteTypeService.deleteVoteTypeById(id);
        return "users deleted Successfully!!";
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping("/votetypes/{id}")
    public TblVotesType updateVoteType(@PathVariable("id") Integer id, @Valid @RequestBody TblVotesType votesType) {
        return voteTypeService.updateVoteType(id,votesType);
    }
}
