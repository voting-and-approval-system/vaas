package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class IssueServiceImpl implements IssueService{
    @Autowired
    IssueRepository issueRepository;
    @Override
    public List<TblIssue> ShowIssue() {
        return issueRepository.findAll();
    }

    @Override
    public TblIssue ShowIssue(Integer id) {
        return issueRepository.findById(id).get();
    }

    @Override
    public TblIssue SaveIssue(TblIssue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public void DeleteIssue(Integer id) {
        issueRepository.deleteById(id);
    }

    @Override
    public TblIssue UpdateIssue(Integer id, TblIssue issue) {
        TblIssue tblIssue = issueRepository.findById(id).get();

        if(Objects.nonNull(issue.getIssueTitle()) &&
                !"".equalsIgnoreCase(issue.getIssueTitle())) {
            tblIssue.setIssueTitle(issue.getIssueTitle());
        }

        if(Objects.nonNull(issue.getIssueDescription()) &&
                !"".equalsIgnoreCase(issue.getIssueDescription())) {
            tblIssue.setIssueDescription(issue.getIssueDescription());
        }

        if(Objects.nonNull(issue.getIssueAttachmentPath()) &&
                !"".equalsIgnoreCase(issue.getIssueAttachmentPath())) {
            tblIssue.setIssueAttachmentPath(issue.getIssueAttachmentPath());
        }

        if(Objects.nonNull(issue.getAllowMultipleOptions()) &&
                !"".equalsIgnoreCase(issue.getAllowMultipleOptions().toString())) {
            tblIssue.setAllowMultipleOptions(issue.getAllowMultipleOptions());
        }

        if(Objects.nonNull(issue.getAssetes()) &&
                !"".equalsIgnoreCase(issue.getAssetes().toString())) {
            tblIssue.setAssetes(issue.getAssetes());
        }

        if(Objects.nonNull(issue.getIssueIsActive()) &&
                !"".equalsIgnoreCase(issue.getIssueIsActive().toString())) {
            tblIssue.setIssueIsActive(issue.getIssueIsActive());
        }

        if(Objects.nonNull(issue.getVoteType()) &&
                !"".equalsIgnoreCase(issue.getVoteType().toString())) {
            tblIssue.setVoteType(issue.getVoteType());
        }

        return issueRepository.save(tblIssue);
    }

    @Override
    public List<TblIssue> ShowActiveIssue(boolean isActive) {
        return issueRepository.findByIssueIsActive(isActive);
    }
}
