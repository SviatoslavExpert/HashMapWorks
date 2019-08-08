package com.granovskiy;

public class Operations {

    public void makeEntries() {
        Provider provider = new Provider();
        for (int i = 0; i < 16 + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(provider.getDriverNames()[i]);
            Node<Car, Driver> node = new Node<>(car, driver);
            System.out.println("node: " + node);
            makeBuckets(node);
        }
    }

    private void makeBuckets(Node<Car, Driver> node) {

    }
}
