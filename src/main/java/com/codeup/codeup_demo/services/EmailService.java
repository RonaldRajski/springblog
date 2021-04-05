package com.codeup.codeup_demo.services;

import com.codeup.codeup_demo.models.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;


    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Ad ad, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        System.out.println(ad.getOwner().getId());
        System.out.println(ad.getOwner().getEmail());
        msg.setTo(ad.getOwner().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        }catch (MailException ex){
            ex.printStackTrace();
        }

    }








}
