package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.repository.IssueRepository;
import com.vaas.vaasbackend.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/issue")
    public List<TblIssue> ShowIssue(){
        return issueService.ShowIssue();
    }

    @PostMapping("/issue")
    public TblIssue SaveIssue(@RequestBody TblIssue issue){

        return issueService.SaveIssue(issue);
    }

    @DeleteMapping("/issue/{id}")
    public String DeleteIssue(@PathVariable Integer id){
        issueService.DeleteIssue(id);
        return "Record Deleted";
    }
}
