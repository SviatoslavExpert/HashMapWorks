package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Node<Car, Driver> node;
    private int index;
    private int bucketSize = 16;
    private List<Node> bucketList = new ArrayList<Node>(16);

    Provider provider = new Provider();

    public void start() {
        checkIfBucketIsEmpty(bucketList);
    }

    private void checkIfBucketIsEmpty(List<Node> bucketList){
        System.out.println(bucketList.isEmpty());
        if(bucketList.isEmpty()) {
            // call method addOneEntry
            Car car = new Car(0);
            Driver driver = new Driver(provider.getDriverNames()[0]);
            Node<Car, Driver> node = new Node<>(car, driver);
            System.out.println();
            System.out.println(node);
            System.out.println("===================");
            System.out.println(bucketList);
            bucketList.add(node);
            System.out.println(bucketList);
        } else {
            // call method addSomeEntries (creating node list)
        }
    }


    //  в методі addEntry якщо size 0, тоді пишемо в node - bucket
    private List<Node> addEntry(Node<Car, Driver> node) {
        if(bucketSize == 0) {
            bucketList.add(node);
            System.out.println(bucketList);
        }
        return bucketList;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public List<Node> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Node> bucketList) {
        this.bucketList = bucketList;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "bucketList=" + bucketList +
                '}';
    }
}
