package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user_singup")
public class TblUserSingup {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private TblUser user;

    @Column(name = "user_email", nullable = false, length = 20)
    private String userEmail;

    @Column(name = "user_password", nullable = false, length = 20)
    private String userPassword;

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}