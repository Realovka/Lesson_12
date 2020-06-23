package com.company.application.actions;

import com.company.application.utils.Input;
import com.company.controllers.CarController;
import com.company.entity.Car;

public abstract class BaseAction implements Action {
    protected CarController carController = new CarController();

    protected Car createCar(){
        int id = Input.getInt("Введите ID");
        String model = Input.getString("Введите модель");
        int price = Input.getInt("Введите цену");
        return new Car(id,model,price);
    }
}
