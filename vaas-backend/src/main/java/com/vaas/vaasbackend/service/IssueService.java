package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblIssue;

import java.util.List;

public interface IssueService {
   public List<TblIssue> ShowIssue();

    public TblIssue ShowIssue(Integer id);

   public TblIssue SaveIssue(TblIssue issue);

   void DeleteIssue(Integer id);

    public TblIssue UpdateIssue(Integer id, TblIssue issue);

    public List<TblIssue> ShowActiveIssue(boolean isActive);
}
