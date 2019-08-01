package com.granovskiy;

public class Car {
    int Id;

    public Car(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                '}';
    }
}
