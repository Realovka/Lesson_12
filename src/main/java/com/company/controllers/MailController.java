package com.company.controllers;

import com.company.dao.DBSubscribersDao;
import com.company.dao.MemorySubscriberDao;
import com.company.dao.SubscribersDao;
import com.company.entity.Subscriber;
import com.company.entity.mail.CongratulationTemplate;
import com.company.entity.mail.DiscountTemplate;
import com.company.entity.mail.Mail;
import com.company.services.MailCongratulateService;
import com.company.services.MailDiscountService;

import java.util.List;

public class MailController {
    private SubscribersDao dao = new DBSubscribersDao();

    public void sendDiscountEmail(){
        List<Subscriber> subscribers = dao.get();
        MailDiscountService mailDiscountService = new MailDiscountService();
        for(Subscriber subscriber: subscribers){
            mailDiscountService.addMail(new Mail(subscriber.getEmail(),new DiscountTemplate(subscriber.getName())));
        }
        new Thread(mailDiscountService).start();
    }

    public void sendCongratulationEmail(){
        List<Subscriber> subscribers = dao.get();
        MailCongratulateService mailCongratulateService = new MailCongratulateService();
        for(Subscriber subscriber: subscribers){
            mailCongratulateService.addMail(new Mail(subscriber.getEmail(),new CongratulationTemplate(subscriber.getName())));
        }
        new Thread(mailCongratulateService).start();
    }
}
