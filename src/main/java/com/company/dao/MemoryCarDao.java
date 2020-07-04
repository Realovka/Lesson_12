package com.company.dao;

import com.company.entity.Car;
import com.company.exception.DuplicateCarException;

import java.util.ArrayList;
import java.util.List;

public class MemoryCarDao implements CarDao {
    private List<Car> cars = new ArrayList<>();
    private static MemoryCarDao instance;

    private MemoryCarDao() {
        cars.add(new Car(1, "Audi", 25000));
        cars.add(new Car(2, "Ford", 30000));
        cars.add(new Car(3, "BMV", 30500));

    }



    public static MemoryCarDao getInstance() {
        if (instance == null) {
            instance = new MemoryCarDao();
        }
        return instance;
    }


    @Override
    public void add(Car car) throws DuplicateCarException {
        if (cars.contains(car)) {
            throw new DuplicateCarException(car.getId());
        }
        cars.add(car);
    }


    @Override
    public List<Car> get() {
        return new ArrayList<>(cars);
    }

    @Override
    public void remove(Car car) {
        cars.remove(car);

    }

    @Override
    public void update(Car car) {
        int index = cars.indexOf(car);
        if (index != -1) {
            cars.set(index, car);
        }

    }
}
