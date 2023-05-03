package com.vaas.vaasbackend.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaas.vaasbackend.entity.TblUserRole;

@Repository
public interface UsersRoleRepository extends JpaRepository<TblUserRole, Long>{

    @Query(nativeQuery = true,value = "select tbl_roles.role_name from tbl_user_role,tbl_users,tbl_roles where tbl_users.user_id = tbl_user_role.user_id and\n" +
            "tbl_user_role.role_id = tbl_roles.role_id and tbl_users.user_email = ?")
    List<String> findUserRoleByEmail(String userEmail);
}





