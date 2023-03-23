package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblIssue;

import java.util.List;

public interface IssueService {
   public List<TblIssue> ShowIssue();

   public TblIssue SaveIssue(TblIssue issue);

   void DeleteIssue(Integer id);
}
