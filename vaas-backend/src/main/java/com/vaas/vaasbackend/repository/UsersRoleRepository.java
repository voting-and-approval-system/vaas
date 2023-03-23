package com.vaas.vaasbackend.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaas.vaasbackend.entity.TblUserRole;

@Repository
public interface UsersRoleRepository extends JpaRepository<TblUserRole, Long>{
  
}





