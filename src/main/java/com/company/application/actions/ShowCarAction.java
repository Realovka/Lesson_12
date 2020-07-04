package com.company.application.actions;


import com.company.entity.Car;

import java.util.List;

public class ShowCarAction extends  BaseAction implements Action {
    @Override
    public String getName() {
        return "Вывод всех автомобилей";
    }

    @Override
    public void action()  {
        List<Car> cars=carController.get();
        System.out.println("=====================");
        for(Car car: cars) {
            System.out.println(car);
        }
        System.out.println("=====================");

    }
}
