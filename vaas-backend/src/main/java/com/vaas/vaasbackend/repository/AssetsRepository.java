package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblAssete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<TblAssete,Integer> {
}