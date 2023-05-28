package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vaas.vaasbackend.entity.TblUserRole;

import javax.validation.Valid;


@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/userrole")
    public List<TblUserRole> showUserRole(){
        return userRoleService.showUserRole();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/userrole/{id}")
	public Optional<TblUserRole> getUserRole(@PathVariable String id)
	{
		return this.userRoleService.getUserRole(Long.parseLong(id));
	}
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/userrole")
    public TblUserRole saveUserRole(@Valid @RequestBody TblUserRole userrole){
        return userRoleService.saveUserRole(userrole);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/userrole/{id}")
    public String deleteUserRoleById(@PathVariable("id") Long id) {
        userRoleService.deleteUserRoleById(id);
        return "users deleted Successfully!!";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/userrole/{id}")
    public TblUserRole updateUserRole(@PathVariable("id") Long id, @Valid @RequestBody TblUserRole userrole) {
        return userRoleService.updateUserRole(id,userrole);
    }

}