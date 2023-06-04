package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.errors.DataNotFoundException;
import com.vaas.vaasbackend.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/issue")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public List<TblIssue> showIssue() throws DataNotFoundException {
        return issueService.showIssue();
    }

    @GetMapping("/issue/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public TblIssue showIssue(@PathVariable Integer id) throws DataNotFoundException {
        return issueService.showIssue(id);
    }

    @GetMapping("issue/active/{isactive}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public List<TblIssue> showActiveIssue(@PathVariable("isactive") boolean isActive) throws DataNotFoundException {
        return issueService.showActiveIssue(isActive);
    }

    @PostMapping("/issue")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public TblIssue saveIssue(@RequestBody TblIssue issue) throws Exception {
        return issueService.saveIssue(issue);
    }

    @PutMapping("/issue/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public TblIssue updateIssue(@PathVariable Integer id, @RequestBody TblIssue issue) throws Exception {
        return issueService.updateIssue(id, issue);
    }

    @GetMapping("/issue/assets/{assetsid}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public List<TblIssue> getActiveIssueForAssets(@PathVariable(name = "assetsid") Integer assetsId) throws DataNotFoundException {
        return issueService.getActiveIssueForAssets(assetsId);
    }

    @DeleteMapping("/issue/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void deleteIssue(@PathVariable Integer id) throws DataNotFoundException {
        issueService.deleteIssue(id);
    }

    @GetMapping("/lastissue")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public Integer getIdOfLastAddedIssue() throws DataNotFoundException {
        return issueService.getIdOfLastAddedIssue();
    }
    @PutMapping("issue/{id}/{isActive}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public TblIssue updateIssueIsActive(@PathVariable("id") Integer issueId, @PathVariable("isActive") boolean isActive) throws DataNotFoundException {
        return issueService.updateIssueIsActive(issueId, isActive);
    }
}
