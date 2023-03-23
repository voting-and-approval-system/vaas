package com.vaas.vaasbackend.service;
import java.util.List;
import java.util.Optional;

import com.vaas.vaasbackend.entity.TblRole;

public interface RoleService {
    public List<TblRole> ShowRoles();

    TblRole SaveRole(TblRole id);

    Optional<TblRole> GetRole(Long id);

    public void DeleteRole(Long id);

    public TblRole UpdateRole(Long id, TblRole role);
}
