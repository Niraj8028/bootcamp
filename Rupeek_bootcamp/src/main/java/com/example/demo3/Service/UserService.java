package com.example.demo3.Service;

import com.example.demo3.DAO.Eventrepo;
import com.example.demo3.DAO.InterestRepo;
import com.example.demo3.DAO.UserRepo;
import com.example.demo3.Models.Event;
import com.example.demo3.Models.Interest;
import com.example.demo3.Models.SignIn;
import com.example.demo3.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepo userRepoObj;

    @Autowired
    Eventrepo eventrepoobj;

    @Autowired
    InterestRepo interestRepoObj;
    public void addUser(Users user) {
        userRepoObj.save(user);
    }

    Long random_id = 1000L;
    public Users addUserEnc(Users user) {
        String password = user.getPwd();
        String encryptedpassword = PasswordEncryption(password);
        //user.setId();

        random_id++;
        //System.out.println(random_id);
        user.setId(random_id);
        user.setPwd(encryptedpassword);
        userRepoObj.save(user);
        return user;
    }
    public String PasswordEncryption(String password)
    {
        String encryptedpassword = null;
        try
        {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        /* Display the unencrypted and encrypted passwords. */
        //System.out.println("Plain-text password: " + password);
        //System.out.println("Encrypted password using MD5: " + encryptedpassword);
        return encryptedpassword;
    }
    public Users Authenticate(SignIn signInDetails) {
        String password = signInDetails.getPassword(); // take from signin
        String email = signInDetails.getEmail(); // take from signin
        String user_password = FindUserByEmail(email);// check email and take password from database
//        Users user=userRepoObj.findByEmail(email);
//        Users user=findByEmail(email);
        //System.out.println("Encrypted from db:"+ user_password);
        List<Users> user=userRepoObj.findByEmail(email);

        if (!user_password.equals("null"))/// check if the password came from login api is same with our database
        {
            Users u=user.get(0);
            String encryptedpassword = PasswordEncryption(password);// encrypt the password from  signin
            //System.out.println("Hii 2 Encrypted from db:"+ encryptedpassword);
            if (encryptedpassword.equals(user_password)) {

                return u;
            }
        }
        return null;
    }

//    }  public Users Authenticate(SignIn signInDetails)
//    {
//        String password = signInDetails.getPassword(); // take from signin
//        String email = signInDetails.getEmail(); // take from signin
//        String user_password = FindUserByEmail(email);// check email and take password from database
//        Users user=userRepoObj.findByEmail(email);
////        Users user=findByEmail(email);
//        //System.out.println("Encrypted from db:"+ user_password);
//
//        if(!user_password.equals("null"))/// check if the password came from login api is same with our database
//        {
//
//            String encryptedpassword = PasswordEncryption(password);// encrypt the password from  signin
//            //System.out.println("Hii 2 Encrypted from db:"+ encryptedpassword);
//            if(encryptedpassword.equals(user_password))
//            {
//
//                return user;
//            }
//        }
//        return null;
//
//
//    }



    public String FindUserByEmail(String email)
    {
        List<Users> all_usr = getAllUser();
        for(Users u : all_usr)
        {
            //System.out.println("User email from db is"+ u.getEmail());
            //System.out.println("User email is"+ email);
            if(u.getEmail().equals(email)) {
//               //if(u.)
                System.out.println("Hii");
                return u.getPwd();

            }

        }
        return "null";
    }
    public Optional<Users> getUserByID(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        return user;
    }

    public List<Users> getAllUser() {
        return userRepoObj.findAll();
    }


    public void deleteUserByID(Long userid) {
        userRepoObj.deleteById(userid);
    }


    public String Addinterest(Long userid,String interestId) {
        Optional<Users> user=userRepoObj.findById(userid);
        if(user.isPresent()){
            Users users=user.get();
            List<String> list=users.getInterest();



            if (list!=null){
//                System.out.println("True here 1");
                list.add(interestId);
                users.setInterest(list);
                userRepoObj.save(users);

            }
            else {
//                System.out.println("True here 2");
                List<String> list1=new ArrayList<>();
                list1.add(interestId);
                users.setInterest(list1);
//                System.out.println(users.getRegEvents());
                userRepoObj.save(users);
            }
        }
        return "interest added successfully";
    }

    public void  AddEvent(Long userid, String event) {
        Optional<Users> user=userRepoObj.findById(userid);
        List<Event> events=eventrepoobj.findByName(event);
        System.out.println("events");

        if(user.isPresent()) {
            Users users = user.get();
            Event event1 = events.get(0);
            String name = users.getFirstName();
            List<String> list = users.getRegEvents();
            List<String> u = event1.getUsers();

            if (list == null) {

                List<String> u1 = new ArrayList<>();
                u1.add(event);
                users.setRegEvents(u1);

            } else {
                list.add(event);
//
                users.setRegEvents(list);

            }
            userRepoObj.save(users);
        }

    }

    public List<Event> getRegEvents(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        List<Event> events=new ArrayList<>();
        Users users = user.get();
        List<Long> regievents = users.getEvents();


            if (regievents != null) {
                for (Long i : regievents) {
                    Optional<Event> event=eventrepoobj.findById(i);
                    Event event1=event.get();

                        events.add(event1);

                }
            }

        return events;
    }

    public List<Users> findFriends(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        List<Users>friend=new ArrayList<>();
        Users users=user.get();
        List<Long>f=users.getFriends();
        if(f!=null){
            for(Long i:f){
                Optional<Users> u=userRepoObj.findById(i);
                Users temp=u.get();
                friend.add(temp);

            }
        }
        return friend;
    }
//    public List<Long> findFriends(Long userid) {
//        Optional<Users> user=userRepoObj.findById(userid);
//
//
//            Users users=user.get();
//            List<Long>friend=users.getFriends();
//            return friend;
//
//
//
//    }

    public List<Interest> getInterests(Long userid) {
        Optional<Users>user= userRepoObj.findById((userid));
        List<Interest>interests=new ArrayList<>();
        if(user.isPresent()){
            Users users=user.get();
            List<String>interest=users.getInterest();
            if(interests!=null){
                for(String i: interest){
                    Interest inter=interestRepoObj.findByInterestName(i);
                    if(inter!=null){
                        interests.add(inter);
                    }
                }
            }

        }
        return interests;
    }

    public String AddFriend(Long userid, Long userid1) {
        Users user1= userRepoObj.findById((userid)).get();
        Users user2= userRepoObj.findById((userid1)).get();

        List<Long>list1=user1.getFriends();
        List<Long>list2=user2.getFriends();

        if(list1!=null){
            list1.add(userid1);
            user1.setFriends(list1);

        }
        else{
            list1=new ArrayList<>();
            list1.add(userid1);
            user1.setFriends(list1);
        }

        if(list2!=null){
            list2.add(userid);
            user2.setFriends(list2);

        }
        else{
            list2=new ArrayList<>();
            list2.add(userid);
            user2.setFriends(list2);
        }
        userRepoObj.save(user2);
        userRepoObj.save(user1);



        return "friend added succesfully";


    }

    public List<Users> findByName(String username) {
        return userRepoObj.findUserByName(username);
    }

    public List<Users> findByLName(String username) {
        return userRepoObj.findUserByLName(username);

    }


    public void register(Long userid, Long eventid) {
        Optional<Users> user=userRepoObj.findById(userid);
        Optional<Event> event=eventrepoobj.findById(eventid);

        Users u=user.get();
        List<Long>e=u.getEvents();
        if(e!=null){
            e.add(eventid);
            u.setEvents(e);
        }
        else{
            List<Long>e1=new ArrayList<>();
            e1.add(eventid);
            u.setEvents(e1);

        }
        userRepoObj.save(u);

    }
}