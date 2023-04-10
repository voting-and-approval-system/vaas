package com.vaas.vaasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<TblIssue,Integer> {

    public List<TblIssue> findByIssueIsActive(boolean isActive);
}
