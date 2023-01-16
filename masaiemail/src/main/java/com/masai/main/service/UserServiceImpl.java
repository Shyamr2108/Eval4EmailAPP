package com.masai.main.service;

import com.masai.main.Repository.EmailRepo;
import com.masai.main.Repository.UserRepo;
import com.masai.main.entity.Email;
import com.masai.main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private EmailRepo emailRepository;

    @Override
    public List<User> registerUser(User user) {
        System.out.print("hello");
        Optional<User> u=this.userRepository.findById(user.getEmail());
        if(u.isEmpty()) {
            System.out.println("user already exists");
            return null;
        }
        this.userRepository.save(user);
        return this.userRepository.findAll();
    }

    @Override
    public boolean loginUser(User user) {
        Optional<User> u=this.userRepository.findById(user.getEmail());
        if(!u.isEmpty()) {
            System.out.println("user already exists");
            return false;
        }

        return true;
    }
    @Override
    public List<Email> getAllMails(String userEmail) {
        User u=this.userRepository.findById(userEmail).get();
        if(u!=null) {
            return this.emailRepository.findByTo(u);
        }
        return null;
    }

    @Override
    public List<Email> getAllStarredMails(String userEmail) {
        User u=this.userRepository.findById(userEmail).get();
        if(u!=null) {
            List<Email> mails=this.emailRepository.findByToAndStarred(u,true);
            return mails;
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        User u=this.userRepository.findById(user.getEmail()).get();
        if(u==null) {
            return null;
        }
        this.userRepository.save(user);
        return user;
    }
}
