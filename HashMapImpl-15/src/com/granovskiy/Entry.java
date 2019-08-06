package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Entry<Car, Driver> {
    private Car car;
    private Driver driver;
    private List<Entry> innerEntryList = new ArrayList<>();;

    public Entry(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    public Entry(List<Entry> innerEntryList) {
        this.innerEntryList = innerEntryList;
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

    public List<Entry> getInnerEntryList() {
        return innerEntryList;
    }

    public void setInnerEntryList(List<Entry> innerEntryList) {
        this.innerEntryList = innerEntryList;
    }


    @Override
    public String toString() {
        return "Entry{" +
                "car=" + car +
                ", driver=" + driver +
                ", innerEntryList=" + innerEntryList +
                '}';
    }
}


    /*    private List<Car> innerCarList;
    private List<Driver> innerDriverList;

    public Entry(List<Car> innerCarList, List<Driver> innerDriverList) {
        this.innerCarList = innerCarList;
        this.innerDriverList = innerDriverList;
    }*/
