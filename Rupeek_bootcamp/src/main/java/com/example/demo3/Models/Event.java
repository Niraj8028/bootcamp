package com.example.demo3.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Events")
public class Event {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Id
    //private long event_id;
    private String eventName;
    private String city;
    private String Date;
    private List<String> interest;

    public Event(String eventName, String city, String Date, List<String> interest) {
        this.eventName = eventName;
        this.city = city;
        this.Date = Date;
        this.interest = interest;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        Date = Date;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }
}
