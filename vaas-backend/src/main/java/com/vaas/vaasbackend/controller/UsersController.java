package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.service.UsersService;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<TblUser> ShowUsers(){
        return usersService.ShowUsers();
    }

    @GetMapping("/users/{id}")
	public Optional<TblUser> GetUsers(@PathVariable String id)
	{
		return this.usersService.GetUsers(Long.parseLong(id));
	}

    @PostMapping("/users")
    public TblUser SaveUser(@RequestBody TblUser user){
        return usersService.SaveUsers(user);
    }


    @DeleteMapping("/users/{id}")
    public String DeleteUserById(@PathVariable("id") Long id) {
        usersService.DeleteUserById(id);
        return "users deleted Successfully!!";
    }

    @PutMapping("/users/{id}")
    public TblUser UpdateUser(@PathVariable("id") Long id,@RequestBody TblUser user) {
        return usersService.UpdateUser(id,user);
    }


}
