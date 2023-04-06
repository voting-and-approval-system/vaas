package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<TblAsset,Integer> {
}
