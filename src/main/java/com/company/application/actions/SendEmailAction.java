package com.company.application.actions;

import com.company.application.exception.StopApplicationException;
import com.company.controllers.MailController;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SendEmailAction extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Отправить рассылку писем";
    }

    @Override
    public void action() throws StopApplicationException {
        boolean flag = true;
        while (flag) {
            System.out.println("1-Отправить письма со скидками");
            System.out.println("2-Отправить поздравления");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    mailController.sendDiscountEmail();
                    flag=false;
                    break;
                case 2:
                    mailController.sendCongratulationEmail();
                    flag=false;
                    break;
                default:
                    System.out.println("Нет такого действия");
            }
        }
    }
}
