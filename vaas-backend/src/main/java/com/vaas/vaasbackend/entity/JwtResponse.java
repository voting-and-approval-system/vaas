package com.vaas.vaasbackend.entity;

import java.util.List;

public class JwtResponse {
    private TblUser user;

    private List<String> roles;

    private String jwtToken;

    public JwtResponse(TblUser user, List<String> roles , String jwtToken) {
        this.user = user;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
