package com.company.services;

import com.company.controllers.CarController;
import com.company.entity.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportService {
    public static void getReport() {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            List<Car> list = new CarController().get();
            writer.write("Список всех автомобилей:\n");
            Integer priceOfCars = 0;
            for (Car item : list) {
                writer.write(item.toString() + "\n");
                priceOfCars += item.getPrice();

            }
            writer.write("\n");
            writer.write("Количество автомобилей: ");
            writer.write(new Integer(list.size()).toString() + "\n\n");
            writer.write("Общая цена автомобилей: ");
            writer.write(priceOfCars.toString() + "\n\n");
            writer.write("Средняя цена: ");
            writer.write(Double.toString(priceOfCars / list.size()));

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
