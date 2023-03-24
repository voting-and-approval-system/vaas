package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<TblUser> ShowUsers() {
        return usersRepository.findAll();
    }

    @Override
    public TblUser SaveUsers(TblUser user) {
        return usersRepository.save(user);
    }
    
    @Override
    public Optional<TblUser> GetUsers(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void DeleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public TblUser UpdateUser(Long id, TblUser user) {
        TblUser depDB = usersRepository.findById(id).get();

        if(Objects.nonNull(user.getUserEmail()) &&
        !"".equalsIgnoreCase(user.getUserEmail())) {
            depDB.setUserEmail(user.getUserEmail());
        }

        return usersRepository.save(depDB);
    }

  



}
 
