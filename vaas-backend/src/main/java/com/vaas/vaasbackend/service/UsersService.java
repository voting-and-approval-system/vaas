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
//        TblRole role = roleRepository.findByRoleName("Admin").get();
//        Set<TblRole> roles = new HashSet<>();
//        roles.add(role);
//        user.setRoleName(roles);


        user.setPassword(getEncodedPassword(user.getPassword()));
        return usersRepository.save(user);
    }
    

//    public Optional<TblUser> getUsers(Long id) {
//        return usersRepository.findById(id);
//    }


    public void deleteUserById(String id) {
        usersRepository.deleteById(id);
    }


    public TblUser updateUser(String id, TblUser user) {
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

    public List<String> getRole(TblUser tblUser){
        return usersRepository.getRole(tblUser.getId());
    }
}
 
