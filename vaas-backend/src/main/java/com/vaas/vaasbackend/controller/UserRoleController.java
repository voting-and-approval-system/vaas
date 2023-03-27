package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vaas.vaasbackend.entity.TblUserRole;
import com.vaas.vaasbackend.service.UserRoleService;

import jakarta.validation.Valid;

@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;


    @GetMapping("/userrole")
    public List<TblUserRole> ShowUserRole(){
        return userRoleService.ShowUserRole();
    }

    @GetMapping("/userrole/{id}")
	public Optional<TblUserRole> GetUserRole(@PathVariable String id)
	{
		return this.userRoleService.GetUserRole(Long.parseLong(id));
	}

    @PostMapping("/userrole")
    public TblUserRole saveUserRole(@Valid @RequestBody TblUserRole userrole){
        return userRoleService.SaveUserRole(userrole);
    }

    @DeleteMapping("/userrole/{id}")
    public String DeleteUserRoleById(@PathVariable("id") Long id) {
        userRoleService.DeleteUserRoleById(id);
        return "users deleted Successfully!!";
    }


    @PutMapping("/userrole/{id}")
    public TblUserRole UpdateUserRole(@PathVariable("id") Long id,@Valid @RequestBody TblUserRole userrole) {
        return userRoleService.UpdateUserRole(id,userrole);
    }

}