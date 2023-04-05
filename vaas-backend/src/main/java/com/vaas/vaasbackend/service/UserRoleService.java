package com.vaas.vaasbackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaas.vaasbackend.entity.TblUserRole;
import com.vaas.vaasbackend.repository.UsersRoleRepository;

@Service
public class UserRoleService {
    @Autowired
    UsersRoleRepository usersrolerepository;


    public List<TblUserRole> showUserRole() {
        return usersrolerepository.findAll();
    }


    public TblUserRole saveUserRole(TblUserRole userrole) {
        return usersrolerepository.save(userrole);
    }
    

    public Optional<TblUserRole> getUserRole(Long id) {
        return usersrolerepository.findById(id);
    }


    public void deleteUserRoleById(Long id) {
        usersrolerepository.deleteById(id);
    }


    public TblUserRole updateUserRole(Long id, TblUserRole userrole) {
        TblUserRole depDB = usersrolerepository.findById(id).get();

        if(Objects.nonNull(userrole.getRole()) &&
        !"".equalsIgnoreCase(userrole.getRole().toString())) {
            depDB.setRole(userrole.getRole());
        }

        return usersrolerepository.save(depDB);
    }

}