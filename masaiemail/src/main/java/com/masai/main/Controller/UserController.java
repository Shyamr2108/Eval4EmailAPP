package com.masai.main.Controller;

import com.masai.main.entity.Email;
import com.masai.main.entity.User;
import com.masai.main.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/masaiuser")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> regUser(@Valid @RequestBody User user) throws Exception{
        System.out.println(user.getMobileNumber());
        System.out.println(user.getEmail());
        List<User> users=this.userServiceImpl.registerUser(user);
        if(users==null)
            throw new Exception("ummmmhmmm!!!!");
        return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logUser(@Valid @RequestBody User user) throws Exception{
        boolean success=this.userServiceImpl.loginUser(user);
        if(success==false)
            throw new Exception("User not found reg.");
        return new ResponseEntity<Boolean>(success,HttpStatus.OK);
    }

    @GetMapping("/mail/{loggedInUser}")
    public ResponseEntity<?> getAllMails(@PathVariable("loggedInUser") String email) throws Exception{
        List<Email> receivedMails=this.userServiceImpl.getAllMails(email);
        if(receivedMails==null)
            throw new Exception("User not found");
        return ResponseEntity.ok(receivedMails);
    }

    @GetMapping("/starred/{loggedInUser}")
    public ResponseEntity<?> starredEmails(@PathVariable("loggedInUser") String email) throws Exception{
        List<Email> starredMails=this.userServiceImpl.getAllStarredMails(email);
        if(starredMails==null)
            throw new Exception("User not found");
        return ResponseEntity.ok(starredMails);
    }

    @PutMapping("/user")
    public ResponseEntity<?> updtUser(@Valid @RequestBody User user) throws Exception{
        User user1=this.userServiceImpl.updateUser(user);
        if(user1==null)
            throw new Exception("User not found");
        return ResponseEntity.ok(user1);
    }
}
