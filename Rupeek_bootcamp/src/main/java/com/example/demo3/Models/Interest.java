package com.example.demo3.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="interests")
public class Interest {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
    private long id;
    private String interestName;

    public long getId() {
        return id;
    }

    public Interest(long id, String interestName) {
        this.id = id;
        this.interestName = interestName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }
}