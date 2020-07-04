package com.company.application.actions;

import com.company.entity.Car;

public class UpdateCarAction extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Изменить автомобиль";
    }

    @Override
    public void action() {
        Car car = createCar();
        carController.update(car);
    }
}
