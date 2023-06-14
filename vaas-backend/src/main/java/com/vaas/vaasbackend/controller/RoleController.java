package com.vaas.vaasbackend.controller;

import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.vaas.vaasbackend.entity.TblRole;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public List<TblRole> showRoles(){
        return roleService.showRoles();
    }
    @PostMapping("/roles")
    public TblRole saveRoles(@Valid @RequestBody TblRole role){
        return roleService.saveRole(role);
    }
    
    @GetMapping("/roles/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
	public Optional<TblRole> getRole(@PathVariable Integer id)
	{
		return this.roleService.getRole(id);
	}

    @DeleteMapping("/roles/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public String deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return "role deleted Successfully!!";
    }

    @PutMapping("/roles/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public TblRole updateUser(@PathVariable("id") Integer id, @Valid @RequestBody TblRole role) {
        return roleService.updateRole(id,role);
    }


}
