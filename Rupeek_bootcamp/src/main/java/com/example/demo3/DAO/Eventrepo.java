package com.example.demo3.DAO;

import com.example.demo3.Models.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Eventrepo extends MongoRepository<Event, Long> {

    @Query("{city : ?0}")
    List<Event> findByCityName(String city);


    @Query("{eventName : ?1}")
    List<Event> findByName(String eventName);
}
