package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user_role")
public class TblUserRole {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private TblUser user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private TblRole role;

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public TblRole getRole() {
        return role;
    }

    public void setRole(TblRole role) {
        this.role = role;
    }

}