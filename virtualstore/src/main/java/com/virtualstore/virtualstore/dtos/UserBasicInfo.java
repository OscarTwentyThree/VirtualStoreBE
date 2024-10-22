package com.virtualstore.virtualstore.dtos;

import java.util.List;

public class UserBasicInfo {

    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;

    private List<RoleSummary> roles;

    public UserBasicInfo() {
    }

    public UserBasicInfo(Long id, String password, String firstName, String lastName, String email, Long phoneNumber, List<RoleSummary> roles) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public List<RoleSummary> getRoles() {
        return roles;
    }

    public UserBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBasicInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBasicInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBasicInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBasicInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBasicInfo setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBasicInfo setRoles(List<RoleSummary> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "UserBasicInfo{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", roles=" + roles +
                '}';
    }

    
}
