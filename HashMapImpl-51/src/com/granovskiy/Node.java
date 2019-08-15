package com.granovskiy;

public class Node<Car, Driver> {
    private Car car;
    private Driver driver;

    public Node(Car car, Driver driver) {
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
        return "Node{" +
                "car=" + car +
                ", driver=" + driver +
                '}';
    }
}
