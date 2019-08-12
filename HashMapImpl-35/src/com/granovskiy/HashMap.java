package com.granovskiy;

import java.util.*;

public class HashMap implements Map {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = 16;
    private Bucket bucket;
    private List<Bucket> bucketList = new ArrayList<>(DEFAULT_CAPACITY);  // entriesContainer initialized

    //  MY METHODS
    private int bucketNumber;
    private int hashCodeValue;
    private Bucket bucketSearched;

    public void makeEmptyHashMap() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            Bucket bucket = new Bucket();
            bucketList.add(bucket);
        }
        System.out.print("bucketList: " + bucketList);
    }

    @Override
    public HashMap put(Car car, Driver driver) {
        getBucketNumber(car, driver);
        findTheBucketSearched(bucketList);
        System.out.println();
        checkNodesInTheBucketSearched(bucketSearched);
        putNode(checkNodesResult, car, driver);

        return null;
    }

    private int getBucketNumber(Object key, Object value) {
        hashCodeValue = key.hashCode();
        bucketNumber = hashCodeValue % mapSize;
        System.out.println();
        System.out.println();
        System.out.print("bucketNumber: " + bucketNumber + ", ");
        return bucketNumber;
    }

    private Bucket findTheBucketSearched(List<Bucket> bucketList) {
        bucketSearched = bucketList.get(bucketNumber);
        return bucketSearched;
    }

    private int checkNodesResult;
    private int checkNodesInTheBucketSearched(Bucket bucketSearched){
        if(bucketSearched.getNode() == null && bucketSearched.getNodeList().isEmpty()) {
            checkNodesResult = 0;
        }
        if(bucketSearched.getNode() != null && bucketSearched.getNodeList().isEmpty()) {
            checkNodesResult = 1;
        }

        if(bucketSearched.getNode() == null && !bucketSearched.getNodeList().isEmpty()) {
            checkNodesResult = 2;
        }
        System.out.print("checkNodesResult: " + checkNodesResult + " ");
        return checkNodesResult;
    }

    private void putNode(int checkNodesResult, Car car, Driver driver) {
        Node node = new Node(car, driver);
        if(checkNodesResult == 0) {
            processEmptyNodeEmptyList(node);
        }
        if(checkNodesResult == 1) {
            //checkIfCollisionIs();
            processFullNodeEmptyList(node);
        }
        if(checkNodesResult == 2) {
            processEmptyNodeSomeList(node);
        }
    }

    private void processEmptyNodeEmptyList(Node node) {
        System.out.println("bucketSearched.getNode()0: " + bucketSearched.getNode());
        bucketSearched.setNode(node);
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
    }

    private void processFullNodeEmptyList(Node node) {
        System.out.println("bucketSearched.getNode() 1 previous: " + bucketSearched.getNode());  //    !!!
        Node previousNode = bucketSearched.getNode();
        bucketSearched.getNodeList().add(0, previousNode);
        bucketSearched.getNodeList().add(1, node);
        bucketSearched.setNode(null);    //    !!!!!
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
    }


    private void processEmptyNodeSomeList(Node node) {
        bucketSearched.getNodeList().add(node);
        bucketSearched.setNode(null);    //    !!!!!
    }

/*
    private boolean checkIfCollisionIs(Node node) {

    }
*/

    public List<Bucket> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    @Override
    public HashMap get(Car car) {
        return null;
    }
}


/*    public void makeEmptyHashMap() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            bucketList.add(null);
        }
        System.out.println("bucketList: " + bucketList);  //  entriesContainer
        System.out.println();
        //fillHashMap(hm, entriesContainer, mapSize);
    }*/
