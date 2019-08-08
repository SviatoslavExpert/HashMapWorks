package com.granovskiy;

import java.util.List;

public class Operations {

    public void makeNodes() {
        Provider provider = new Provider();
        for (int i = 0; i < 16 + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(provider.getDriverNames()[i]);
            Node<Car, Driver> node = new Node<>(car, driver);
            System.out.println("node: " + node);
            makeBuckets(node, car);
        }
    }

    private void makeBuckets(Node<Car, Driver> node, Car car) {
        int bucketNumber;
        int hashCodeValue;
        hashCodeValue = car.hashCode();
        bucketNumber = hashCodeValue % 16;
        List<Node> list = new List();
        Bucket.setBucketList(list);



    }
}
