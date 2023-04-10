package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public Optional<TblRole> getRole(@PathVariable Integer id)
	{
		return this.roleService.getRole(id);
	}

    @DeleteMapping("/roles/{id}")
    public String deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return "role deleted Successfully!!";
    }

    @PutMapping("/roles/{id}")
    public TblRole updateUser(@PathVariable("id") Integer id, @Valid @RequestBody TblRole role) {
        return roleService.updateRole(id,role);
    }

    @GetMapping("/roles/{rolename}")
    public Optional<TblRole> findByRoleName(@PathVariable String rolename)
    {
        return this.roleService.findByRoleName(rolename);
    }


    

}
