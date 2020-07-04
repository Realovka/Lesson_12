package com.company.dao;

import com.company.entity.Car;
import com.company.exception.DuplicateCarException;

import java.util.List;

public interface CarDao {
    void add(Car car) throws DuplicateCarException;
    List<Car> get();
    void remove(Car car);
    void update(Car car);

}
