package com.example.demo3.DAO;

import com.example.demo3.Models.Event;
import com.example.demo3.Models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<Users,Long> {
//    @Query("{email : ?0}")
//    Users findByEmail(String email);
}
