package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Node<Car, Driver> node;
    private int index;
    private int bucketSize = 16;
    private List<Node> nodeList = new ArrayList<Node>(16);

    Provider provider = new Provider();

    public void start() {
        generateNode();
    }

    //  iterating buckets

    private void generateNode() {
        Car car = new Car(0);
        Driver driver = new Driver(provider.getDriverNames()[0]);
        Node<Car, Driver> node = new Node<>(car, driver);
        System.out.println(node);
        calculateBucketNumber(car);
        //return node;
    }

    int bucketNumber;
    private void calculateBucketNumber(Car car) {
        bucketNumber = car.hashCode() % 16;
        checkIfBucketIsEmpty(bucketNumber, nodeList);
        System.out.println(bucketNumber);
        //return bucketNumber;
    }

    private void checkIfBucketIsEmpty(int bucketNumber, List<Node> bucketList){
        //nodeList.get(bucketNumber);   //  getting the specific bucket
        //System.out.println(nodeList.get(bucketNumber));
/*        if(nodeList.get(bucketNumber) == null) {
            System.out.println("true");
            // call method addOneEntry

        } else {
            // call method addSomeEntries (creating node list)
            System.out.println("false");
        }*/
    }


    //  в методі addEntry якщо size 0, тоді пишемо в node - bucket
    private List<Node> addEntry(Node<Car, Driver> node) {
        if(bucketSize == 0) {
            nodeList.add(node);
            System.out.println(nodeList);
        }
        return nodeList;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "nodeList=" + nodeList +
                '}';
    }
}


/*            Car car = new Car(0);
            Driver driver = new Driver(provider.getDriverNames()[0]);
            Node<Car, Driver> node = new Node<>(car, driver);
            System.out.println();
            System.out.println(node);
            System.out.println("===================");
            System.out.println(nodeList);
            nodeList.add(node);
            System.out.println(nodeList);*/