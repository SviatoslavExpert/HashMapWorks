package com.granovskiy;

public class Entry<Car, Driver> {
    private Car car;
    private Driver driver;

    public Entry(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
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
