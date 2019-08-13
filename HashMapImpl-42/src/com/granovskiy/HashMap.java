package com.granovskiy;

import java.util.*;

public class HashMap implements Map<Car, Driver> {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = 16;
    private List<Bucket> bucketList = new ArrayList<>(DEFAULT_CAPACITY);  // entriesContainer initialized

    void makeEmptyHashMap() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            Bucket bucket = new Bucket();
            bucketList.add(bucket);
        }
        System.out.print("bucketList: " + bucketList);
    }

    @Override
    public Driver put(Car car, Driver driver) {
        int bucketNumber = getBucketNumber(car);
        Bucket bucketSearched = findTheBucketSearched(bucketList, bucketNumber, car, driver);
        return processNode(bucketSearched, car, driver);
    }

    private int getBucketNumber(Car car) {
        int hashCodeValue = car.hashCode();
        int bucketNumberValue = hashCodeValue % mapSize;
        System.out.println();
        System.out.println("bucketNumber: " + bucketNumberValue + ", ");
        return bucketNumberValue;
    }

    private Bucket findTheBucketSearched(List<Bucket> bucketList, int bucketNumber, Car car, Driver driver) {
        return bucketList.get(bucketNumber);
    }

    private Driver processNode(Bucket bucketSearched, Car car, Driver driver) {
        Driver resultObject = null;
        Node node = new Node(car, driver);
        if (bucketSearched.getNode() == null && bucketSearched.getNodeList().isEmpty()) {
            System.out.println("Process: processEmptyNodeEmptyList");
            resultObject = processEmptyNodeEmptyList(node, bucketSearched);
        } else if (bucketSearched.getNode() != null && bucketSearched.getNodeList().isEmpty()) {
            System.out.println("Process: processFullNodeEmptyList");
            resultObject = processFullNodeEmptyList(node, bucketSearched);
        } else if (bucketSearched.getNode() == null && !bucketSearched.getNodeList().isEmpty()) {
            System.out.println("Process: processEmptyNodeSomeList");
            resultObject = processEmptyNodeSomeList(node, bucketSearched);
        }
        return resultObject;
    }

    private Driver processEmptyNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("Original node state: " + bucketSearched.getNode());
        bucketSearched.setNode(node);
        System.out.println("Bucket state: " + bucketSearched);
        return null;
    }

    private Driver processFullNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("Original node state: " + bucketSearched.getNode());  //    !!!
        Node previousNode = bucketSearched.getNode();
        bucketSearched.getNodeList().add(0, previousNode);

        boolean collisionIs = checkIfCollisionIs(node, bucketSearched);


        bucketSearched.getNodeList().add(1, node);
        bucketSearched.setNode(null);    //    !!!!!
        System.out.println("New node: " + node);
        System.out.println("Bucket state: " + bucketSearched);
        return null;  // previousNode.getDriver()
    }

    private Driver processEmptyNodeSomeList(Node node, Bucket bucketSearched) {
        //boolean collisionIs = checkIfCollisionIs(node, bucketSearched);
        bucketSearched.getNodeList().add(node);
        System.out.println("New node: " + node);
        System.out.println("Bucket state: " + bucketSearched);
        return null;
    }

    private boolean checkIfCollisionIs(Node node, Bucket bucketSearched) {
        boolean booleanResult = false;
        for (int i = 0; i < bucketSearched.getNodeList().size(); i++) {
            if (node.getCar().hashCode() == bucketSearched.getNodeList().get(i).hashCode()
                || node.getCar().hashCode() == bucketSearched.getNode().getCar().hashCode()) {  //  bug is here
                booleanResult = true;
            }
        }
        System.out.println("Collision: " + booleanResult);
        return booleanResult;
    }

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
    public Driver get(Object key) {
        return null;
    }

/*    @Override
    public Object put(Object key, Object value) {
        return null;
    }*/

    @Override
    public Driver remove(Object key) {
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
    public Set<Entry<Car, Driver>> entrySet() {
        return null;
    }
}


/*    @Override
    public Driver put(Car car, Driver driver) {
        int hashCodeValue = car.hashCode();
        int bucketNumber = hashCodeValue % mapSize;
        System.out.println();
        System.out.print("bucketNumber: " + bucketNumber + ", ");
        findTheBucketSearched(bucketList, bucketNumber, car, driver);
        return null;
    }*/


//System.out.print("My node: " + node);
//System.out.println();
//System.out.print(bucketSearched);
