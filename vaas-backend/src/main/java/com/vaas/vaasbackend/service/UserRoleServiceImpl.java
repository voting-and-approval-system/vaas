package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaas.vaasbackend.entity.TblUserRole;
import com.vaas.vaasbackend.repository.UsersRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UsersRoleRepository usersrolerepository;

    @Override
    public List<TblUserRole> ShowUserRole() {
        return usersrolerepository.findAll();
    }

    @Override
    public TblUserRole SaveUserRole(TblUserRole id) {
        return usersrolerepository.save(id);
    }
    
    @Override
    public Optional<TblUserRole> GetUserRole(Long id) {
        return usersrolerepository.findById(id);
    }

    @Override
    public void DeleteUserRoleById(Long id) {
        usersrolerepository.deleteById(id);
    }

    @Override
    public TblUserRole UpdateUserRole(Long id, TblUserRole userrole) {
        TblUserRole depDB = usersrolerepository.findById(id).get();

        if(Objects.nonNull(userrole.getRole()) &&
        !"".equalsIgnoreCase(userrole.getRole().toString())) {
            depDB.setRole(userrole.getRole());
        }

        return usersrolerepository.save(depDB);
    }

}