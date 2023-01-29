package com.example.demo3.Models;

import com.mongodb.lang.NonNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="users")
public class Users {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @NonNull
    private String pwd;
//    @DBRef
    private List<String> interest;
    private List<String> regEvents;

    public long getId() {
        return id;
    }

    public Users(long id, String firstName, String lastName, String email, String pwd, List<String> interest, List<String> regEvents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pwd=pwd;
        this.interest = interest;
        this.regEvents = regEvents;
    }

    public void setId(long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public List<String> getRegEvents() {
        return regEvents;
    }

    public void setRegEvents(List<String> regEvents) {
        this.regEvents = regEvents;
    }
}
