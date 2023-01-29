package com.example.demo3.Models;

import com.mongodb.lang.NonNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="users")
public class Users {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    @NonNull
    private String pwd;
    //    @DBRef
    private List<String> interest;
    private List<String> regEvents;
    private List<Long> friends;

    public Users(long id, String firstName, String lastName, String email, String city, @NonNull String pwd, List<String> interest, List<String> regEvents, List<Long> friends) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.pwd = pwd;
        this.interest = interest;
        this.regEvents = regEvents;
        this.friends = friends;
    }

    public long getId() {
        return id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NonNull
    public String getPwd() {
        return pwd;
    }

    public void setPwd(@NonNull String pwd) {
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

    public List<Long> getFriends() {
        return friends;
    }

    public void setFriends(List<Long> friends) {
        this.friends = friends;
    }
}
