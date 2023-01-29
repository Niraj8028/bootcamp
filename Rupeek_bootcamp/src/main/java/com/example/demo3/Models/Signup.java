package com.example.demo3.Models;
import java.util.List;
public class Signup {
    private String name;
    private String pwd;
    private String email;
    private String city;

    public Signup(String name, String pwd, String email, String city) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
