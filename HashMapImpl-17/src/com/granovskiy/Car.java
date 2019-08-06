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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId();
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                '}';
    }
}
