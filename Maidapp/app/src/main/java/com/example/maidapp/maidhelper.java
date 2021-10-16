package com.example.maidapp;

public class maidhelper {
    String   firstname,lastname,phonem;



    public maidhelper( String firstname, String lastname, String phonem) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.phonem = phonem;
    }







    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getphonem() {
        return phonem;
    }

    public void setphonem(String phonem) {
        this.phonem = phonem;
    }

}
