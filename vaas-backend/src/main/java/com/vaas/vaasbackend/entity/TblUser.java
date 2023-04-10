package com.vaas.vaasbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

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
    private LocalDate userJoiningDate;

    @Column(name = "user_updated_date", nullable = false)
    private LocalDate userUpdatedDate;

    @Column(name = "user_is_active", nullable = false)
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


    @ManyToMany
    @JoinTable(name = "tbl_user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<TblRole> role;
    public Set<TblRole> getRoleName() {
        return role;
    }
    public void setRoleName(Set<TblRole> role) {
        this.role = role;
    }

}