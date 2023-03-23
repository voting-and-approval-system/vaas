package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Optional;

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
    public TblRole SaveRole(TblRole role) {
        return rolerepository.save(role);
    }
    
    @Override
    public Optional<TblRole> GetRole(Long id) {
        return rolerepository.findById(id);
    }
    
    
    @Override
    public void DeleteRole(Long user) {
        rolerepository.deleteById(user);
    }


}
