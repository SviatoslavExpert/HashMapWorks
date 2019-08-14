package com.granovskiy;

import java.util.*;

public class HashMap implements Map<Car, Driver> {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = DEFAULT_CAPACITY;
    private List<Bucket> bucketList = new ArrayList<>(DEFAULT_CAPACITY);  // entriesContainer initialized

    public static int getDefaultCapacity() {
        return DEFAULT_CAPACITY;
    }

    public void makeEmptyHashMap(int mapSize) {
        for (int i = 0; i < mapSize; i++) {
            Bucket bucket = new Bucket();
            bucketList.add(bucket);
        }
        System.out.print("bucketList: " + bucketList);
        //return bucketList;
    }

    @Override
    public Driver put(Car car, Driver driver) {
        //checkIfLoadFactorIs(bucketList);
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
        System.out.println("bucketList: " + bucketList);
        return null;
    }

    private Driver processFullNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("Original node state: " + bucketSearched.getNode());
        Node previousNode = bucketSearched.getNode();
        Driver processNodeResult = null;
        if(checkNodeIfCollisionIs(node, bucketSearched)) {
            processNodeResult = bucketSearched.getNode().getDriver();
        }
        bucketSearched.getNodeList().add(0, previousNode);
        bucketSearched.getNodeList().add(1, node);
        bucketSearched.setNode(null);
        System.out.println("New node: " + node);
        System.out.println("Bucket state: " + bucketSearched);
        System.out.println("bucketList: " + bucketList);
        return processNodeResult;
    }

    private Driver processEmptyNodeSomeList(Node node, Bucket bucketSearched) {
        Driver processListResult = checkListIfCollisionIs(node, bucketSearched);
        bucketSearched.getNodeList().add(node);
        System.out.println("New node: " + node);
        System.out.println("Bucket state: " + bucketSearched);
        System.out.println("bucketList: " + bucketList);
        return processListResult;
    }

    private boolean checkNodeIfCollisionIs(Node node, Bucket bucketSearched) {
        boolean booleanResult = false;
        if (node.getCar().hashCode() == bucketSearched.getNode().getCar().hashCode()) {
            booleanResult = true;
        }
        System.out.println("Node collision: " + booleanResult);
        return booleanResult;
    }

    private Driver checkListIfCollisionIs(Node node, Bucket bucketSearched) {
        Driver processListResult = null;
        for (int i = 0; i < bucketSearched.getNodeList().size(); i++) {
            if (node.getCar().hashCode() == bucketSearched.getNodeList().get(i).getCar().hashCode()) {
                processListResult = (Driver) bucketSearched.getNodeList().get(i).getDriver();
            }
        }
        System.out.println("List collision: " + processListResult);
        return processListResult;
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



/*    private void checkIfLoadFactorIs(List<Bucket> bucketList) {
        int count = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            if(bucketList.get(i) != null) {
                count++;
            }
        }
        if(count / bucketList.size() >= DEFAULT_LOAD_FACTOR / 100) {
            makeEmptyHashMap(mapSize * 2);
            reindexAndMakeNewBucketList(bucketList);
        }
        //return bucketList;
    }

    private List<Bucket> reindexAndMakeNewBucketList(List<Bucket> bucketList) {

    }*/







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
