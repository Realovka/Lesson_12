package com.company.entity;

public class Car {
    private int id;
    private String model;
    private int price;

    public Car(int id, String model, int price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Car() {
    }

    public Car(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return  true;
        if(obj==null||getClass()!=obj.getClass()) return  false;
        Car car = (Car) obj;
        return id==car.id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
