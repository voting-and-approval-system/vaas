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
import com.vaas.vaasbackend.entity.TblRole;

import com.vaas.vaasbackend.service.RoleService;

import jakarta.validation.Valid;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<TblRole> ShowRoles(){
        return roleService.ShowRoles();
    }
    @PostMapping("/roles")
    public TblRole SaveRoles(@Valid @RequestBody TblRole role){
        return roleService.SaveRole(role);
    }
    
    @GetMapping("/roles/{id}")
	public Optional<TblRole> GetRole(@PathVariable String id)
	{
		return this.roleService.GetRole(Long.parseLong(id));
	}

    @DeleteMapping("/roles/{id}")
    public String DeleteRole(@PathVariable("id") Long id) {
        roleService.DeleteRole(id);
        return "role deleted Successfully!!";
    }

    @PutMapping("/roles/{id}")
    public TblRole UpdateUser(@PathVariable("id") Long id,@Valid @RequestBody TblRole role) {
        return roleService.UpdateRole(id,role);
    }


    

}
