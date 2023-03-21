package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.tbl_assetes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetesRepository extends JpaRepository<tbl_assetes, Integer> {
}
