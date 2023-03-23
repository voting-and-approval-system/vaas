package com.vaas.vaasbackend.service;


import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.entity.TblUserRole;

public interface UserRoleService {

    
    public List<TblUserRole> ShowUserRole();

    Optional<TblUserRole> GetUserRole(Long id);

    TblUserRole SaveUserRole(TblUserRole id);

    public void DeleteUserRoleById(Long id);

    public TblUserRole UpdateUserRole(Long id, TblUserRole userrole);

    
}