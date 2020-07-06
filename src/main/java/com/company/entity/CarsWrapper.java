package com.company.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
public class CarsWrapper {
    private List<Car> cars;

    public CarsWrapper() {
    }

    public CarsWrapper(List<Car> cars) {
        this.cars = cars;
    }

    @XmlElement(name = "car")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
