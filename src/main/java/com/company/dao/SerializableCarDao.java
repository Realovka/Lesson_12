package com.company.dao;

import com.company.entity.Car;
import com.company.exception.DuplicateCarException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableCarDao implements CarDao {

    private static final String PATH = "car.bin";

    @Override
    public void add(Car car) throws DuplicateCarException {
        List<Car> cars = get();
        if (cars.contains(car)) {
            throw new DuplicateCarException(car.getId());
        }
        cars.add(car);
        save(cars);
    }

    @Override
    public List<Car> get() {
        try {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
                return (List<Car>) objectInputStream.readObject();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void remove(Car car) {
        List<Car> cars = get();
        cars.remove(car);
        save(cars);

    }

    @Override
    public void update(Car car) {
        List<Car> cars = get();
        int index = cars.indexOf(car);
        if (index != -1) {
            cars.set(index, car);
            save(cars);

        }
    }

    private void save(List<Car> cars) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

