package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoundRepository extends JpaRepository<TblRound,Integer> {
    public List<TblRound> findByIssueId(Integer id);
}
