package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<TblOption,Integer> {
    public List<TblOption> findByIssueId(Integer id);
}
