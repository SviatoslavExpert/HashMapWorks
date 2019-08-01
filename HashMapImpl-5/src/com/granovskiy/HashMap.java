package com.granovskiy;

import java.util.Arrays;

public class HashMap<Car, Driver> {
    private final int DEFAULT_CAPACITY = 16;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    //private Entry<Car, Driver>[] table;
    Car car;
    Driver driver;

    public HashMap() {
        this.size = size;
    }

    public HashMap(int size, Car car, Driver driver) {
        this.size = size;
        this.car = car;
        this.driver = driver;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public float getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
        return "HashMap{" +
                "DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", DEFAULT_LOAD_FACTOR=" + DEFAULT_LOAD_FACTOR +
                ", size=" + size +
                ", car=" + car +
                ", driver=" + driver +
                '}';
    }

/*    public void add(Car car, Driver driver) {
        this.put(car, driver);
    }*/
}
