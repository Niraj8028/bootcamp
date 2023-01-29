package com.example.demo3.DAO;

import com.example.demo3.Models.Event;
import com.example.demo3.Models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<Users,Long> {
    @Query("{firstName : ?0}")
    List<Users> findUserByName(String firstName);

    @Query("{lastName : ?1}")
    List<Users> findUserByLName(String lastName);

    @Query("{email : ?0}")
    List<Users> findByEmail(String email);

}
