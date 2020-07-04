package com.company.application.actions;

import com.company.application.exception.StopApplicationException;
import com.company.controllers.MailController;

public class SendEmailAction extends BaseAction implements Action{

    @Override
    public String getName() {
        return "Отправить рассылку писем";
    }

    @Override
    public void action() throws StopApplicationException {
        mailController.sendEmail();

    }
}
