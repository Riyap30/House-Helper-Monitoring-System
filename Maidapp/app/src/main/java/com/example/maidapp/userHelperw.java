package com.example.maidapp;

public class userHelperw {
    String  name,username,city,soc,phone,pass;

    public userHelperw() {

    }

    public userHelperw(String name, String username, String city, String soc, String phone, String pass) {
        this.name = name;
        this.username = username;
        this.city = city;
        this.soc = soc;
        this.phone = phone;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
