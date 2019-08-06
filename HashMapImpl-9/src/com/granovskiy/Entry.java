package com.granovskiy;

import java.util.*;

public class Entry<Car, Driver> {
    private Car car;
    private Driver driver;
    private List<Car> innerCarList;
    private List<Driver> innerDriverList;

    public Entry(List<Car> innerCarList.get(k), List<Driver> innerDriverList) {
        this.innerCarList = innerCarList;
        this.innerDriverList = innerDriverList;
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

    public List<Car> getInnerCarList() {
        return innerCarList;
    }

    public void setInnerCarList(List<Car> innerCarList) {
        this.innerCarList = innerCarList;
    }

    public List<Driver> getInnerDriverList() {
        return innerDriverList;
    }

    public void setInnerDriverList(List<Driver> innerDriverList) {
        this.innerDriverList = innerDriverList;
    }

    @Override
    public String toString() {
        for (int i = 0; i < 11; i++) {                  //   to be improved  !!!

        }
        return "Entry{" +
                "innerCarList=" + innerCarList +
                ", innerDriverList=" + innerDriverList +
                '}';
    }
}
