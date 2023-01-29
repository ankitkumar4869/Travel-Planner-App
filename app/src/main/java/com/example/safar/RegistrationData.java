package com.example.safar;

public class RegistrationData {
    String fname, email, mobile, lname;

    public RegistrationData() {

    }

    public RegistrationData(String email,String fname, String lname, String mobile) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
