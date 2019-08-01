package com.granovskiy;

public class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                '}';
    }
}
