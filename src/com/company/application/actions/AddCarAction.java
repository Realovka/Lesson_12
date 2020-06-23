package com.company.application.actions;

import com.company.application.utils.Input;
import com.company.entity.Car;
import com.company.exception.DuplicateCarException;

public class AddCarAction extends BaseAction implements Action {


    @Override
    public String getName() {
        return "Добавить модель автомобиля";
    }

    @Override
    public void action()  {
        Car car = createCar();

        try {
            carController.add(car);
        } catch (DuplicateCarException e) {
            System.out.println(e.getMessage());
        }

    }
}
