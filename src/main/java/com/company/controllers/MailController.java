package com.company.controllers;

import com.company.dao.MemorySubscriberDao;
import com.company.dao.SubscribersDao;
import com.company.entity.Subscriber;
import com.company.entity.mail.CongratulationTemplate;
import com.company.entity.mail.DiscountTemplate;
import com.company.entity.mail.Mail;
import com.company.services.MailService;

import java.util.List;

public class MailController {
    private SubscribersDao dao = new MemorySubscriberDao();

    public void sendEmail(){
        List<Subscriber> subscribers = dao.get();
        MailService mailService = new MailService();
        for(Subscriber subscriber: subscribers){
            mailService.addMail(new Mail(subscriber.getEmail(),new DiscountTemplate(subscriber.getName())));
        }
        new Thread(mailService).start();
    }


}
