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

    @GetMapping("/issue/{id}")
    public TblIssue ShowIssue(@PathVariable Integer id){
        return issueService.ShowIssue(id);
    }

    @GetMapping("issue/active/{isactive}")
    public List<TblIssue> ShowActiveIssue(@PathVariable("isactive") boolean isActive){
        return issueService.ShowActiveIssue(isActive);
    }

    @PostMapping("/issue")
    public TblIssue SaveIssue(@RequestBody TblIssue issue){
        return issueService.SaveIssue(issue);
    }

    @PutMapping("/issue/{id}")
    public TblIssue UpdateIssue(@PathVariable Integer id,@RequestBody TblIssue issue){
        return issueService.UpdateIssue(id,issue);
    }

    @DeleteMapping("/issue/{id}")
    public String DeleteIssue(@PathVariable Integer id){
        issueService.DeleteIssue(id);
        return "Record Deleted";
    }
}
