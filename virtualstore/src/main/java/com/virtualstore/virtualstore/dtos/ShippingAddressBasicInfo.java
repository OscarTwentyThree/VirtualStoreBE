package com.virtualstore.virtualstore.dtos;

public class ShippingAddressBasicInfo {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public ShippingAddressBasicInfo() {
    }

    public ShippingAddressBasicInfo(Long id, String street, String city, String state, String country, String zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public ShippingAddressBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public ShippingAddressBasicInfo setStreet(String street) {
        this.street = street;
        return this;
    }

    public ShippingAddressBasicInfo setCity(String city) {
        this.city = city;
        return this;
    }

    public ShippingAddressBasicInfo setState(String state) {
        this.state = state;
        return this;
    }

    public ShippingAddressBasicInfo setCountry(String country) {
        this.country = country;
        return this;
    }

    public ShippingAddressBasicInfo setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public String toString() {
        return "ShippingAddressBasicInfo{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
    
}
