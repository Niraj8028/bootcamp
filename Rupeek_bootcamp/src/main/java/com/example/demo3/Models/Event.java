package com.example.demo3.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="Events")
public class Event {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Id
    private long event_id;
    private String eventName;
    private String city;
    private String Date;
    private List<String> interest=new ArrayList<>();
    private List<String> users;

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", city='" + city + '\'' +
                ", Date='" + Date + '\'' +
                ", interest=" + interest +
                ", users=" + users +
                '}';
    }

    public Event(long event_id, String eventName, String city, String Date, List<String> interest, List<String> users) {
        this.event_id = event_id;
        this.eventName = eventName;
        this.city = city;
        this.Date = Date;
        this.interest = interest;
        this.users = users;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
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

    public void setDate(String date) {
        this.Date = date;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
