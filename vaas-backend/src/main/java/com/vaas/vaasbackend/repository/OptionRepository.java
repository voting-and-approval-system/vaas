package com.vaas.vaasbackend.repository;

import com.vaas.vaasbackend.entity.TblOption;
import com.vaas.vaasbackend.entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<TblOption,Integer> {
}
