package com.granovskiy;

import java.util.*;

public class HashMap implements Map {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = 16;
    private Bucket bucket;
    private List<Bucket> bucketList = new ArrayList<>(DEFAULT_CAPACITY);  // entriesContainer initialized

    void makeEmptyHashMap() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            Bucket bucket = new Bucket();
            bucketList.add(bucket);
        }
        System.out.print("bucketList: " + bucketList);
    }

    public void put(Car car, Driver driver) {
        int hashCodeValue = car.hashCode();
        int bucketNumber = hashCodeValue % mapSize;
        System.out.println();
        System.out.print("bucketNumber: " + bucketNumber + ", ");
        findTheBucketSearched(bucketList, bucketNumber, car, driver);
    }

    private void findTheBucketSearched(List<Bucket> bucketList, int bucketNumber, Car car, Driver driver) {
        Bucket bucketSearched = bucketList.get(bucketNumber);
        checkNodesInTheBucketSearched(bucketSearched, car, driver);
    }

    private void checkNodesInTheBucketSearched(Bucket bucketSearched, Car car, Driver driver){
        int checkNodesResult = 10;
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
        putNode(checkNodesResult, car, driver, bucketSearched);
    }

    private void putNode(int checkNodesResult, Car car, Driver driver, Bucket bucketSearched) {
        Node node = new Node(car, driver);
        if(checkNodesResult == 0) {
            processEmptyNodeEmptyList(node, bucketSearched);
        }
        if(checkNodesResult == 1) {
            //checkIfCollisionIs();
            processFullNodeEmptyList(node, bucketSearched);
        }
        if(checkNodesResult == 2) {
            processEmptyNodeSomeList(node, bucketSearched);
        }
    }

    private void processEmptyNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("bucketSearched.getNode()0: " + bucketSearched.getNode());
        bucketSearched.setNode(node);
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
    }

    private void processFullNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("bucketSearched.getNode() 1 previous: " + bucketSearched.getNode());  //    !!!
        Node previousNode = bucketSearched.getNode();
        bucketSearched.getNodeList().add(0, previousNode);
        bucketSearched.getNodeList().add(1, node);
        bucketSearched.setNode(null);    //    !!!!!
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
    }

    private void processEmptyNodeSomeList(Node node, Bucket bucketSearched) {
        bucketSearched.getNodeList().add(node);
        bucketSearched.setNode(null);    //    !!!!!
    }

/*
    private boolean checkIfCollisionIs(Node node) {

    }
*/

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
