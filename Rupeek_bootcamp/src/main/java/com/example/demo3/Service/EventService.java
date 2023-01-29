package com.example.demo3.Service;

import com.example.demo3.DAO.Eventrepo;
import com.example.demo3.DAO.UserRepo;
import com.example.demo3.Models.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EventService {


    Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    Eventrepo eventrepoObj;




    public void addevent(Event event) {
        eventrepoObj.save(event);
    }

    public List<Event> getEvent() {
        return eventrepoObj.findAll();
    }



     public List<Event> findByCity(String cityName) {
         List<Event>events=eventrepoObj.findByCityName(cityName);
         return events;
     }

    public List<Event> findByInt(String interest) {
        List<Event> events=eventrepoObj.findAll();
        List<Event> eventList=new ArrayList<>();
        if (events!=null) {
            for (Event i : events) {
                List<String> inter = i.getInterest();
                if (inter.contains(interest)) {
                    eventList.add(i);
                }
            }
        }
        return eventList;
    }

    public List<Event> getAllEventInCityAndInterest(String city, String interest) {
        List<Event> events=eventrepoObj.findByCityName(city);
        List<Event> eventList=new ArrayList<>();
        if (events!=null) {
            for (Event i : events) {
                List<String> inter = i.getInterest();
                if (inter.contains(interest)) {
                    eventList.add(i);
                }
            }
        }
        return eventList;
    }
}
