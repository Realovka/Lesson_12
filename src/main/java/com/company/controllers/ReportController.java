package com.company.controllers;


import com.company.entity.Car;
import com.company.services.ReportService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportController implements Runnable {
    public void run() {
        ReportService.getReport();
    }
}
