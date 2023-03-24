package com.vaas.vaasbackend.repository;




import com.vaas.vaasbackend.entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<TblUser, Long>{

    
    }







