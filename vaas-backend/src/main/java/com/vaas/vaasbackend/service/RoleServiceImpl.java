package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaas.vaasbackend.repository.RoleRepository;
import com.vaas.vaasbackend.entity.TblRole;


@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository rolerepository;

    @Override
    public List<TblRole> ShowRoles() {
        return rolerepository.findAll();
    }

    @Override
    public TblRole SaveRole(TblRole id) {
        return rolerepository.save(id);
    }
    
    @Override
    public Optional<TblRole> GetRole(Long id) {
        return rolerepository.findById(id);
    }
    
    
    @Override
    public void DeleteRole(Long id) {
        rolerepository.deleteById(id);
    }

    @Override
    public TblRole UpdateRole(Long id, TblRole role) {
        TblRole depDB = rolerepository.findById(id).get();

        if(Objects.nonNull(role.getRoleName()) &&
        !"".equalsIgnoreCase(role.getRoleName())) {
            depDB.setRoleName(role.getRoleName());
        }

        return rolerepository.save(depDB);
    }



}
