package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.entity.TblUser;
import com.vaas.vaasbackend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import javax.validation.Valid;


@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<TblUser> showUsers(){
        return usersService.showUsers();
    }

    @GetMapping("/users/{id}")
	public Optional<TblUser> getUsers(@PathVariable String id)
	{
		return this.usersService.getUsers(Long.parseLong(id));
	}

    @PostMapping("/users")
    public TblUser saveUser(@Valid @RequestBody TblUser user){
        return usersService.saveUsers(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        usersService.deleteUserById(id);
        return "users deleted Successfully!!";
    }

    @PutMapping("/users/{id}")
    public TblUser updateUser(@PathVariable("id") Long id, @Valid @RequestBody TblUser user) {
        return usersService.updateUser(id,user);
    }

    @GetMapping("/users/{userEmail}")
    public Optional<TblUser> findByUserEmail(@PathVariable String userEmail)
    {
        return this.usersService.findByUserEmail(userEmail);
    }

}