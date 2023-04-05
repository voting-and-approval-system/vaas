package com.vaas.vaasbackend.entity;

public class JwtResponse {
    private TblUser user;

    private String jwtToken;

    public JwtResponse(TblUser user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
