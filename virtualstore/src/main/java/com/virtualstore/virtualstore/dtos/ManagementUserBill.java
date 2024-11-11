package com.virtualstore.virtualstore.dtos;

import java.util.Collection;

public class ManagementUserBill {

    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;

    private Collection<BillManagement> bills;

    public ManagementUserBill() {
    }

    public ManagementUserBill(Long id, String password, String firstName, String lastName, String email, Long phoneNumber, Collection<BillManagement> bills) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bills = bills;
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

    public Collection<BillManagement> getBills() {
        return bills;
    }

    public ManagementUserBill setId(Long id) {
        this.id = id;
        return this;
    }

    public ManagementUserBill setPassword(String password) {
        this.password = password;
        return this;
    }

    public ManagementUserBill setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ManagementUserBill setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ManagementUserBill setEmail(String email) {
        this.email = email;
        return this;
    }

    public ManagementUserBill setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ManagementUserBill setBills(Collection<BillManagement> bills) {
        this.bills = bills;
        return this;
    }

    @Override
    public String toString() {
        return "ManagementUserBill{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", bills=" + bills +
                '}';
    }
    
}
