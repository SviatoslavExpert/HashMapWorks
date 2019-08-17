package com.granovskiy;

import java.util.*;

public class HashMap implements Map<Car, Driver> {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = DEFAULT_CAPACITY;
    private List<Bucket> bucketList = new ArrayList<>(mapSize);  // entriesContainer initialized

    public int getMapSize() {
        return mapSize;
    }

    public List<Bucket> getBucketList() {
        return bucketList;
    }

    public void makeEmptyHashMap(int mapSize, List<Bucket> bucketList) {
        for (int i = 0; i < mapSize; i++) {
            Bucket bucket = new Bucket();
            bucket.setIndex(i);
            bucketList.add(bucket);
        }
        System.out.println("bucketList: " + bucketList);
    }

    //  METHOD PUT
    @Override
    public Driver put(Car car, Driver driver) {
        Bucket bucketSearched = bucketList.get(car.hashCode() % mapSize);
        System.out.println("bucketSearched index: " + bucketSearched.getIndex());
        return processNode(bucketSearched, car, driver);
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
        if (checkNodeIfCollisionIs(node, bucketSearched)) {
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

    private void checkIfLoadFactorIs(List<Bucket> bucketList) {
        int count = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            if(bucketList.get(i) != null) {
                count++;
            }
        }
        if(count / bucketList.size() >= DEFAULT_LOAD_FACTOR / 100) {
            int newMapSize = mapSize * 2;
            makeEmptyHashMap(newMapSize, bucketList);
            reindexAndMakeNewBucketList(bucketList, newMapSize);
        }
    }

    private List<Bucket> reindexAndMakeNewBucketList(List<Bucket> bucketList, int newMapSize) {
        int bucketListSize = bucketList.size();
        for (int i = 0; i < bucketListSize; i++) {
        }
        return null;
    }

    //  METHOD GET
    @Override
    public Driver get(Object key) {
        Car car = (Car) key;
        Driver objectDriver = checkBucket(bucketList.get(car.hashCode() % mapSize), car);
        System.out.println("bucket: " + bucketList.get(car.hashCode() %  mapSize));
        return objectDriver;
    }

    private Driver checkBucket(Bucket bucketSearched, Car car) {
        Driver checkBucketObject = null;
        if (bucketSearched.getNode() != null) {  // counting filled nodes inside one bucket
            System.out.println("bucketSearched.getNode()" + bucketSearched.getNode());
            if (car.equals(bucketSearched.getNode().getCar())) {
                System.out.println("The object is found in the node: " +
                        bucketSearched.getNode().getCar() + " " + bucketSearched.getNode().getDriver() +
                        " bucketIndex" + bucketSearched.getIndex());
                checkBucketObject = bucketSearched.getNode().getDriver();
                if (checkBucketObject != null) {
                    System.out.println("checkBucketObject: " + checkBucketObject);
                    return checkBucketObject;
                }
            }
        }
        if (!bucketSearched.getNodeList().isEmpty()) {
            int bucketListSize = bucketSearched.getNodeList().size();
            for (int i = 0; i < bucketListSize; i++) {
                if (car.equals(bucketSearched.getNodeList().get(i).getCar())) {
                    System.out.println("The object is found in the nodeList: " +
                            bucketSearched.getNodeList().get(i).getCar() + " " +
                            bucketSearched.getNodeList().get(i).getDriver() +
                            " bucketIndex" + bucketSearched.getIndex());
                    checkBucketObject = (Driver) bucketSearched.getNodeList().get(i).getDriver();
                    if (checkBucketObject != null) {
                        System.out.println("checkBucketObject: " + checkBucketObject);
                        return checkBucketObject;
                    }
                }
            }
            System.out.println("bucketSearched.getNodeList()" + bucketSearched.getNodeList());
        }
        return checkBucketObject;
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
