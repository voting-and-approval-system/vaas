package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.vaas.vaasbackend.entity.TblUserRole;

import javax.validation.Valid;


@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/userrole")
    public List<TblUserRole> showUserRole(){
        return userRoleService.showUserRole();
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/userrole/{id}")
	public Optional<TblUserRole> getUserRole(@PathVariable String id)
	{
		return this.userRoleService.getUserRole(Long.parseLong(id));
	}
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PostMapping("/userrole")
    public TblUserRole saveUserRole(@Valid @RequestBody TblUserRole userrole){
        return userRoleService.saveUserRole(userrole);
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/userrole/{id}")
    public String deleteUserRoleById(@PathVariable("id") Long id) {
        userRoleService.deleteUserRoleById(id);
        return "users deleted Successfully!!";
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping("/userrole/{id}")
    public TblUserRole updateUserRole(@PathVariable("id") Long id, @Valid @RequestBody TblUserRole userrole) {
        return userRoleService.updateUserRole(id,userrole);
    }

}