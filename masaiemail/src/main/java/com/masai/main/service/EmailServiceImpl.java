package com.masai.main.service;

import com.masai.main.Repository.EmailRepo;
import com.masai.main.Repository.UserRepo;
import com.masai.main.entity.Email;
import com.masai.main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private EmailRepo emailRepository;

    @Override
    public boolean sendMail(Email email) {
        User u1=this.userRepository.findById(email.getFrom().getEmail()).get();
        User u2=this.userRepository.findById(email.getTo().getEmail()).get();

        if(u1==null || u2==null) return false;

        email.setFrom(u1);
        email.setTo(u2);
        this.emailRepository.save(email);

        return true;
    }

    @Override
    public boolean starredMail(int id) {
        Email email=this.emailRepository.findById(id).get();
        email.setStarred(true);
        return true;
    }

    @Override
    public boolean deleteMail(int id) {

        Email e=this.emailRepository.findById(id).get();
        this.emailRepository.delete(e);

        return true;
    }

}
