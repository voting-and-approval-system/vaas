package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.vaas.vaasbackend.entity.TblUser;
import org.springframework.beans.factory.annotation.Autowired;


import com.vaas.vaasbackend.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UsersRepository usersRepository;


    public List<TblUser> showUsers() {
        return usersRepository.findAll();
    }


    public TblUser saveUsers(TblUser user) {
        user.setPassword(getEncodedPassword(user.getPassword()));
        return usersRepository.save(user);
    }
    

    public Optional<TblUser> getUsers(Long id) {
        return usersRepository.findById(id);
    }


    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }


    public TblUser updateUser(Long id, TblUser user) {
        TblUser depDB = usersRepository.findById(id).get();

        if(Objects.nonNull(user.getUserEmail()) &&
        !"".equalsIgnoreCase(user.getUserEmail())) {
            depDB.setUserEmail(user.getUserEmail());
        }

        return usersRepository.save(depDB);
    }


    public Optional<TblUser> findByUserEmail(String userEmail) {
        return usersRepository. findByUserEmail(userEmail);
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

  



}
 
