package com.vaas.vaasbackend.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaas.vaasbackend.entity.TblUser;

@Repository
public interface UsersRepository extends JpaRepository<TblUser, Long>{

    
    }







