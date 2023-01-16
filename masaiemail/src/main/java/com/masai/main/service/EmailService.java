package com.masai.main.service;

import com.masai.main.Repository.EmailRepo;
import com.masai.main.Repository.UserRepo;
import com.masai.main.entity.Email;
import com.masai.main.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmailService {
    public boolean sendMail(Email email);
    public boolean starredMail(int id);
    public boolean deleteMail(int id);

}
