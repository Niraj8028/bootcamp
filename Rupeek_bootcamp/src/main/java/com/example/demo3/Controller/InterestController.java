package com.example.demo3.Controller;

import com.example.demo3.Models.Interest;
import com.example.demo3.Service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class InterestController {
    @Autowired
    InterestService interestserviceObj;

    @CrossOrigin
    @GetMapping(path = "/interests")
    public List<Interest> getAllInterests(){
        return interestserviceObj.getInterests();


    }
    @CrossOrigin
    @PostMapping(path = "/add/interest")
    public String addInterest(@RequestBody Interest interest){
        interestserviceObj.AddInterest(interest);
        return "interest added successfully";
    }


    @CrossOrigin
    @GetMapping(path = "/interest/{interest_id}")
    public Optional<Interest> getInterestById(@PathVariable Long interest_id){
        Optional<Interest> interest=interestserviceObj.getByid(interest_id);
        return interest;
    }

}
