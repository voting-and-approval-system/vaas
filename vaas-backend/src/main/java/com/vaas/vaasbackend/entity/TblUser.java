package com.vaas.vaasbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_users")
public class TblUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Size(max = 20)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Size(max = 12)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;

    @Size(max = 20)
    @NotNull
    @Column(name = "user_email", nullable = false, length = 20)
    private String userEmail;

    @Size(max = 6)
    @NotNull
    @Column(name = "house_number", nullable = false, length = 6)
    private String houseNumber;

    @NotNull
    @Column(name = "user_joining_date", nullable = false)
    private LocalDate userJoiningDate;

    @NotNull
    @Column(name = "user_updated_date", nullable = false)
    private LocalDate userUpdatedDate;

    @NotNull
    @Column(name = "user_is_active", nullable = false)
    private Boolean userIsActive = false;

    @Size(max = 80)
    @NotNull
    @Column(name = "password", nullable = false, length = 80)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public LocalDate getUserJoiningDate() {
        return userJoiningDate;
    }

    public void setUserJoiningDate(LocalDate userJoiningDate) {
        this.userJoiningDate = userJoiningDate;
    }

    public LocalDate getUserUpdatedDate() {
        return userUpdatedDate;
    }

    public void setUserUpdatedDate(LocalDate userUpdatedDate) {
        this.userUpdatedDate = userUpdatedDate;
    }

    public Boolean getUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(Boolean userIsActive) {
        this.userIsActive = userIsActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}