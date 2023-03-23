package com.vaas.vaasbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaas.vaasbackend.entity.TblRole;

@Repository
public interface RoleRepository extends JpaRepository<TblRole, Long>{

    

    
       
}
