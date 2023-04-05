package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vaas.vaasbackend.entity.TblRole;

import javax.validation.Valid;


@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<TblRole> showRoles(){
        return roleService.showRoles();
    }
    @PostMapping("/roles")
    public TblRole saveRoles(@Valid @RequestBody TblRole role){
        return roleService.saveRole(role);
    }
    
    @GetMapping("/roles/{id}")
	public Optional<TblRole> getRole(@PathVariable String id)
	{
		return this.roleService.getRole(Long.parseLong(id));
	}

    @DeleteMapping("/roles/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return "role deleted Successfully!!";
    }

    @PutMapping("/roles/{id}")
    public TblRole updateUser(@PathVariable("id") Long id, @Valid @RequestBody TblRole role) {
        return roleService.updateRole(id,role);
    }


    

}
