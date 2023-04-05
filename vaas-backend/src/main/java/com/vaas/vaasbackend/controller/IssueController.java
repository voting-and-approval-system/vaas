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
    public List<TblIssue> showIssue(){
        return issueService.showIssue();
    }

    @GetMapping("/issue/{id}")
    public TblIssue showIssue(@PathVariable Integer id){
        return issueService.showIssue(id);
    }

    @GetMapping("issue/active/{isactive}")
    public List<TblIssue> showActiveIssue(@PathVariable("isactive") boolean isActive){
        return issueService.showActiveIssue(isActive);
    }

    @PostMapping("/issue")
    public TblIssue saveIssue(@RequestBody TblIssue issue){
        return issueService.saveIssue(issue);
    }

    @PutMapping("/issue/{id}")
    public TblIssue updateIssue(@PathVariable Integer id, @RequestBody TblIssue issue){
        return issueService.updateIssue(id,issue);
    }

    @DeleteMapping("/issue/{id}")
    public String deleteIssue(@PathVariable Integer id){
        issueService.deleteIssue(id);
        return "Record Deleted";
    }
}
