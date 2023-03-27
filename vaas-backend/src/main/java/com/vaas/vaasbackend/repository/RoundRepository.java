package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblRound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundRepository extends JpaRepository<TblRound,Integer> {
    public List<TblRound> findByIssueId(Integer id);
}
