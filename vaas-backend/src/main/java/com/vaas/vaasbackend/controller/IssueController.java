package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/issue")
    public List<TblIssue> ShowIssue(){
        return issueService.showIssue();
    }

    @GetMapping("/issue/{id}")
    public TblIssue ShowIssue(@PathVariable Integer id){
        return issueService.showIssue(id);
    }

    @GetMapping("issue/active/{isactive}")
    public List<TblIssue> ShowActiveIssue(@PathVariable("isactive") boolean isActive){
        return issueService.showActiveIssue(isActive);
    }

    @PostMapping("/issue")
    public TblIssue SaveIssue(@RequestBody TblIssue issue){
        return issueService.saveIssue(issue);
    }

    @PutMapping("/issue/{id}")
    public TblIssue UpdateIssue(@PathVariable Integer id,@RequestBody TblIssue issue){
        return issueService.updateIssue(id,issue);
    }

    @DeleteMapping("/issue/{id}")
    public String DeleteIssue(@PathVariable Integer id){
        issueService.deleteIssue(id);
        return "Record Deleted";
    }
}
