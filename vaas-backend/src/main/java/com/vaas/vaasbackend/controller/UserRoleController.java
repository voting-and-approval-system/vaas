package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vaas.vaasbackend.entity.TblUserRole;

import javax.validation.Valid;


@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;


    @GetMapping("/userrole")
    public List<TblUserRole> showUserRole(){
        return userRoleService.showUserRole();
    }

    @GetMapping("/userrole/{id}")
	public Optional<TblUserRole> getUserRole(@PathVariable String id)
	{
		return this.userRoleService.getUserRole(Long.parseLong(id));
	}

    @PostMapping("/userrole")
    public TblUserRole saveUserRole(@Valid @RequestBody TblUserRole userrole){
        return userRoleService.saveUserRole(userrole);
    }

    @DeleteMapping("/userrole/{id}")
    public String deleteUserRoleById(@PathVariable("id") Long id) {
        userRoleService.deleteUserRoleById(id);
        return "users deleted Successfully!!";
    }


    @PutMapping("/userrole/{id}")
    public TblUserRole updateUserRole(@PathVariable("id") Long id, @Valid @RequestBody TblUserRole userrole) {
        return userRoleService.updateUserRole(id,userrole);
    }

}