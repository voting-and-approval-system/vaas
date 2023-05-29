package com.vaas.vaasbackend.repository;

import java.util.List;
import java.util.Optional;


import com.vaas.vaasbackend.entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaas.vaasbackend.entity.TblUserRole;

@Repository
public interface UsersRoleRepository extends JpaRepository<TblUserRole, Long>{

    @Query(nativeQuery = true,value = "select tbl_roles.role_name from tbl_user_role,tbl_users,tbl_roles where tbl_users.user_id = tbl_user_role.user_id and\n" +
            "tbl_user_role.role_id = tbl_roles.role_id and tbl_users.user_email = ?")
    List<String> findUserRoleByEmail(String userEmail);

    @Query(nativeQuery = true,value = "SELECT u.*\n" +
            "FROM tbl_users u\n" +
            "LEFT JOIN tbl_user_role ur ON u.user_id = ur.user_id\n" +
            "WHERE ur.user_role_id IS NULL;")
    List<String> showUserWithNoRole();
}





