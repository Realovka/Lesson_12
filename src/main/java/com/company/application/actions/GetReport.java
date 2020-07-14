package com.company.application.actions;

import com.company.application.config.ReportApplication;
import com.company.application.exception.StopApplicationException;
import com.company.controllers.ReportController;

public class GetReport implements Action{
    @Override
    public String getName() {
        return "Показать отчет о товарах";
    }

    @Override
    public void action() throws StopApplicationException {
        ReportController reportController=new ReportController();
        new Thread(reportController).start();
    }
}
