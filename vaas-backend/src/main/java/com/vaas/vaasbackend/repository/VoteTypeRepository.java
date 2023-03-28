package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblVotesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteTypeRepository extends JpaRepository<TblVotesType, Integer> {
}
