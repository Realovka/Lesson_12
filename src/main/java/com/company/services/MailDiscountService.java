package com.company.services;

import com.company.dao.MemorySubscriberDao;
import com.company.entity.Subscriber;
import com.company.entity.mail.CongratulationTemplate;
import com.company.entity.mail.DiscountTemplate;
import com.company.entity.mail.Mail;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MailDiscountService implements Runnable {
    private Queue<Mail> mails = new ArrayDeque<>();

    public MailDiscountService(ArrayDeque<Mail> mails) {
        this.mails = mails;
    }

    public MailDiscountService() {
    }

    public Queue<Mail> getMails() {
        return mails;
    }

    public void setMails(Queue<Mail> mails) {
        this.mails = mails;
    }

    public void run(){
        Iterator<Mail> iter=mails.iterator();
        Iterator<Subscriber> subscriberIterator=new MemorySubscriberDao().get().iterator();
        while (iter.hasNext() && subscriberIterator.hasNext()){
            Mail mail=iter.next();
           try (BufferedWriter writer=new BufferedWriter(new FileWriter("mails/"+System.currentTimeMillis()+".txt"))){
               writer.write("Кому:"+mail.getEmail());
               writer.newLine();
               writer.write(new DiscountTemplate(subscriberIterator.next().getName()).getText());
           } catch (IOException e){
               e.printStackTrace();
           }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void addMail(Mail mail){
        mails.offer(mail);
    }
}
