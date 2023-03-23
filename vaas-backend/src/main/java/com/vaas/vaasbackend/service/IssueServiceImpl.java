package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblIssue;
import com.vaas.vaasbackend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService{
    @Autowired
    IssueRepository issueRepository;
    @Override
    public List<TblIssue> ShowIssue() {
        return issueRepository.findAll();
    }

    @Override
    public TblIssue SaveIssue(TblIssue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public void DeleteIssue(Integer id) {
        issueRepository.deleteById(id);
    }
}
