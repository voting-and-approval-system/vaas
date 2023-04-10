package com.vaas.vaasbackend.repository;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaas.vaasbackend.entity.TblRole;

@Repository
public interface RoleRepository extends JpaRepository<TblRole, Integer>{


    Optional<TblRole> findByRoleName(String rolename);
}
