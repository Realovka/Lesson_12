package com.company.controllers;

import com.company.dao.CarDao;
import com.company.dao.MemoryCarDao;
import com.company.dao.SerializableCarDao;
import com.company.entity.Car;
import com.company.exception.DuplicateCarException;

import java.util.List;

public class CarController {
    private CarDao carDao= new SerializableCarDao();

    public void add(Car car) throws DuplicateCarException {
        if (car.getModel().startsWith("F")){
            car.setPrice(car.getPrice()-10);
        }
        carDao.add(car);
    }

    public List<Car> get(){
        return carDao.get();
    }

    public void remove(int id){
        carDao.remove(new Car(id));
    }

    public void update(Car car){
        carDao.update(car);
    }

}
