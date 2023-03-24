package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblUser;

import java.util.List;
import java.util.Optional;


public interface UsersService {

    public List<TblUser> ShowUsers();

    Optional<TblUser> GetUsers(Long id);

    TblUser SaveUsers(TblUser user);

    public void DeleteUserById(Long id);

    public TblUser UpdateUser(Long id, TblUser user);
    
}
