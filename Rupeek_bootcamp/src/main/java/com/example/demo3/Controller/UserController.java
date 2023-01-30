package com.example.demo3.Controller;

import com.example.demo3.Models.Event;
import com.example.demo3.Models.Interest;
import com.example.demo3.Models.SignIn;
import com.example.demo3.Models.Users;
import com.example.demo3.Service.EventService;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userServiceObj;

    @Autowired
    EventService eventServiceObj;

    @CrossOrigin
    @PostMapping(path="/registerUser") /////////Add users to the database
    public Users addUserEnc(@RequestBody Users user){
        userServiceObj.addUserEnc(user);
        return user;
    }
    @CrossOrigin
    @PostMapping("/signIn")
    public Users Authenticate(@RequestBody SignIn signInDetails)
    {
        return userServiceObj.Authenticate(signInDetails);

    }
//    @CrossOrigin
//    @PostMapping(path="/add/user")
//    public String addUser(@RequestBody Users user){
//        userServiceObj.addUser(user);
//        return "user added succesfuly";
//    }
    @CrossOrigin
    @GetMapping(path="/user/{userid}")
    public Optional<Users> getUserById(@PathVariable Long userid){
        Optional<Users> user=userServiceObj.getUserByID(userid);
        return user;
    }
    @CrossOrigin
    @PutMapping(path = "/add/interest/{userid}/{text}")
    public String addInterest(@PathVariable Long userid,@PathVariable String text){
        return userServiceObj.Addinterest(userid,text);
    }
    @CrossOrigin
    @PutMapping(path = "/register/event/{userid}/{event}")
    public String RegisterEvent(@PathVariable Long userid,@PathVariable String event){
        userServiceObj.AddEvent(userid,event);
//        eventServiceObj.AddUser(userid,event);
        return "Event registered successfully";


    }
    @CrossOrigin
    @PutMapping(path = "/register/event/{userid}/to/{eventid}")
    public String RegisterToEvent(@PathVariable Long userid,@PathVariable Long eventid){
        userServiceObj.register(userid,eventid);
//        eventServiceObj.AddUser(userid,event);
        return "Event registered successfully";


    }

    @CrossOrigin
    @PutMapping(path = "/add/{userid}/to/{userid1}")
    public String RegisterEvent(@PathVariable Long userid,@PathVariable Long userid1){
        return userServiceObj.AddFriend(userid,userid1);

    }



    @CrossOrigin
    @GetMapping(path="/users")
    public List<Users> getUsers(){
        List<Users> userlist =userServiceObj.getAllUser();
        return userlist;
    }
    @CrossOrigin
    @DeleteMapping(path = "/user/{userid}")
    public String deleteUserById(@PathVariable Long userid ){
        userServiceObj.deleteUserByID(userid);
        return "user deleted succesfully";
    }
    @CrossOrigin
    @GetMapping(path = "/user/events/{userid}")
    public List<Event> getRegisteredEvents(@PathVariable Long userid){
        return userServiceObj.getRegEvents(userid);

    }
    @CrossOrigin
    @GetMapping(path = "/user/interests/{userid}")
    public List<Interest> get(@PathVariable Long userid){
        return userServiceObj.getInterests(userid);

    }

    @CrossOrigin
    @GetMapping(value = "/search/{username}")
    public List<Users>getUserByName(@PathVariable String username){
        List<Users>user= userServiceObj.findByName(username);
        return user;

    }@CrossOrigin
    @GetMapping(value = "/friends/{userid}")
    public List<Users>getAllFriends(@PathVariable Long userid){
        return userServiceObj.findFriends(userid);


    }
//    @CrossOrigin
//    @GetMapping(value = "/search/last/{userLname}")
//    public List<Users>getUserByLName(@PathVariable String userLname){
//        List<Users>user= userServiceObj.findByLName(userLname);
//        return user;
//    }

}
