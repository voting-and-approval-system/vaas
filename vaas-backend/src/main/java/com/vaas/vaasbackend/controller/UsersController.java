package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
public class UsersController {

    @Autowired
    UsersService usersService;



    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public List<TblUser> showUsers(){
        return usersService.showUsers();
    }

    @PostMapping("/user")
    public TblUser saveUser(@Valid @RequestBody TblUser user){
        return usersService.saveUsers(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        usersService.deleteUserById(id);
        return "users deleted Successfully!!";
    }

    @PutMapping("/users/{id}")
    public TblUser updateUser(@PathVariable("id") int id, @RequestBody TblUser user) {
        return usersService.updateUser(id,user);
    }

    @GetMapping("/users/{emailid}")
    public Optional<TblUser> findByUserEmail(@PathVariable("emailid") String userEmail)
    {
        return this.usersService.findByUserEmail(userEmail);
    }


    @GetMapping("/newusers")
    public List<TblUser> showUserWithNoRole()
    {
        return this.usersService.showUserWithNoRole();
    }



}