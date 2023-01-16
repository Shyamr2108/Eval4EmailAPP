package com.masai.main.service;

import com.masai.main.entity.Email;
import com.masai.main.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> registerUser(User user);
    public boolean loginUser(User user);
    public List<Email> getAllMails(String userEmail);
    public List<Email> getAllStarredMails(String userEmail);
    public User updateUser(User user);
}
