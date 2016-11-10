package com.toba.bll.user;

import java.io.Serializable;

public class User implements Serializable{
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private String userName;
    private String password;
    private String tempPassword;
    
    public User(){
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city ="";
        state = "";
        zipcode = "";
        email = "";
        userName = "";
        password = "";
        tempPassword = "";
    }
    
    public User(String firstName, String lastName, String phone, String address,
            String city, String state, String zipcode, String email,
            String userName, String password, String tempPassword){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.tempPassword = tempPassword;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return lastName + zipcode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTempPassword() {
        return "welcome1";
    }

    public void setTempPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
