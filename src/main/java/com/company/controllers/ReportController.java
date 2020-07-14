package com.company.controllers;


import com.company.application.config.ReportApplication;

public class ReportController implements Runnable {
    public void run() {
        ReportApplication.getMessage();
    }
}
