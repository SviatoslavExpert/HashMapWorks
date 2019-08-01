package com.granovskiy;

public class Entry<Car, Driver> {
    Car car;
    Driver driver;
    //Entry<Car, Driver>[] entry;

    public Entry(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "car=" + car +
                ", driver=" + driver +
                '}';
    }
}
