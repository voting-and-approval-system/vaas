package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaas.vaasbackend.repository.RoleRepository;
import com.vaas.vaasbackend.entity.TblRole;


@Service
public class RoleService {
    @Autowired
    RoleRepository rolerepository;


    public List<TblRole> showRoles() {
        return rolerepository.findAll();
    }


    public TblRole saveRole(TblRole role) {
        return rolerepository.save(role);
    }
    

    public Optional<TblRole> getRole(Long id) {
        return rolerepository.findById(id);
    }
    
    

    public void deleteRole(Long id) {
        rolerepository.deleteById(id);
    }


    public TblRole updateRole(Long id, TblRole role) {
        TblRole depDB = rolerepository.findById(id).get();

        if(Objects.nonNull(role.getRoleName()) &&
        !"".equalsIgnoreCase(role.getRoleName())) {
            depDB.setRoleName(role.getRoleName());
        }

        return rolerepository.save(depDB);
    }



}
