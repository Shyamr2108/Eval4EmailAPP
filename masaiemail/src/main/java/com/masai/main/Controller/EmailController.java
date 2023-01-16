package com.masai.main.Controller;

import com.masai.main.entity.Email;
import com.masai.main.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masaiemail")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @PostMapping("/mail")
    public ResponseEntity<?> sendMail(@RequestBody Email email) throws Exception{
        boolean success=this.emailServiceImpl.sendMail(email);
        if(success==false)
            throw new Exception("email does not exist in the database");
        return ResponseEntity.ok(success);
    }

    @PostMapping("/starred/{id}")
    public ResponseEntity<?> starrMail(@PathVariable("id") int id){
        boolean success=this.emailServiceImpl.starredMail(id);
        return ResponseEntity.ok(success);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMail(@PathVariable("id") int id){
        boolean success=this.emailServiceImpl.deleteMail(id);
        return ResponseEntity.ok(success);
    }
}
