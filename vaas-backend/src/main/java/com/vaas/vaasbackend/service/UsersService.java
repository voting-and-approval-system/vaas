package com.vaas.vaasbackend.service;

import java.util.*;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.repository.RoleRepository;
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
    RoleRepository roleRepository;


    public List<TblUser> showUsers() {
        return usersRepository.findAll();
    }


    public TblUser saveUsers(TblUser user) {
//        user.setPassword(getEncodedPassword(user.getPassword()));
        return usersRepository.save(user);
    }
    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }

    public TblUser updateUser(int id, TblUser user) {
        TblUser updateUser = usersRepository.findById(id).get();

        if(Objects.nonNull(user.getUserEmail()) &&
        !"".equalsIgnoreCase(user.getUserEmail())) {
            updateUser.setUserEmail(user.getUserEmail());
        }
        if(Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())){
            updateUser.setFirstName(user.getFirstName());
        }
        if(Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())){
            updateUser.setLastName(user.getLastName());
        }
        if(Objects.nonNull(user.getUserIsActive()) && !"".equalsIgnoreCase(user.getUserIsActive().toString())){
            updateUser.setUserIsActive(user.getUserIsActive());
        }
        if(Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())){
            updateUser.setPhoneNumber(user.getPhoneNumber());
        }
        if(Objects.nonNull(user.getHouseNumber()) && !"".equalsIgnoreCase(user.getHouseNumber())){
            updateUser.setHouseNumber(user.getHouseNumber());
        }
        if(Objects.nonNull(user.getUserUpdatedDate()) && !"".equalsIgnoreCase(user.getUserUpdatedDate().toString())){
            updateUser.setUserUpdatedDate(user.getUserUpdatedDate());
        }
        if(Objects.nonNull(user.getUserJoiningDate()) && !"".equalsIgnoreCase(user.getUserJoiningDate().toString())){
            updateUser.setUserJoiningDate(user.getUserJoiningDate());
        }

        return usersRepository.save(updateUser);
    }

    public Optional<TblUser> findByUserEmail(String userEmail) {
        return usersRepository. findByUserEmail(userEmail);
    }
//    public String getEncodedPassword(String password) {
//        return passwordEncoder.encode(password);
//    }

    public List<String> getRole(TblUser tblUser){
        return usersRepository.getRole(tblUser.getId());
    }


    public List<TblUser> showUserWithNoRole() {
        return usersRepository.showUserWithNoRole();
    }

}
 
