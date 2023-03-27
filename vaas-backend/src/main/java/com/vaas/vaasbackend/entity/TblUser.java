package com.vaas.vaasbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_users")
public class TblUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 20)
    @NotBlank(message = "Please enter First Name")
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    @NotBlank(message = "Please enter Last Name")
    private String lastName;

    @Column(name = "phone_number", nullable = false, length = 12)
    @NotBlank(message = "Please enter Phone Number")
    @Size(max = 10)
    private String phoneNumber;

    @Column(name = "user_email", nullable = false, length = 20)
    @NotBlank(message = "Please enter email address")
    @Email
    private String userEmail;

    @Column(name = "house_number", nullable = false, length = 6)
    @NotBlank(message = "Please enter house Number")
    private String houseNumber;

    @Column(name = "user_joining_date", nullable = false)
    @NotBlank(message = "Please enter joining date")
    private LocalDate userJoiningDate;

    @Column(name = "user_updated_date", nullable = false)
    @NotBlank(message = "Please enter update date")
    private LocalDate userUpdatedDate;

    @Column(name = "user_is_active", nullable = false)
    @NotBlank(message = "Is user active?")
    private Boolean userIsActive = false;

    @Column(name = "password", nullable = false, length = 80)
    @NotBlank(message = "Please enter password")
    @Size(max = 20, min = 8)
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