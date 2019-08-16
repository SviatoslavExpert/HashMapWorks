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
        System.out.print("bucketList: " + bucketList);
    }

    //  METHOD PUT
    @Override
    public Driver put(Car car, Driver driver) {
        //checkIfLoadFactorIs(bucketList);
        //int bucketNumber = getBucketNumberForPutting(car);
        Bucket bucketSearched = bucketList.get(car.hashCode() % mapSize);
        System.out.println("bucketSearched index: " + bucketSearched.getIndex());
        System.out.println("bucketSearched from put : " + bucketSearched);
        return analyzeNode(bucketSearched, car, driver);
    }

    private Driver analyzeNode(Bucket bucketSearched, Car car, Driver driver) {
        Driver resultObject = null;
        Node node = new Node(car, driver);
        if (bucketSearched.getNode() == null && bucketSearched.getNodeList().isEmpty()) {
            System.out.println("Process: processEmptyNodeEmptyList");
            resultObject = putIfEmptyNodeEmptyList(node, bucketSearched);
        } else if (bucketSearched.getNode() != null && bucketSearched.getNodeList().isEmpty()) {
            System.out.println("Process: processFullNodeEmptyList");
            resultObject = putIfFullNodeEmptyList(node, bucketSearched);
        } else if (bucketSearched.getNode() == null && !bucketSearched.getNodeList().isEmpty()) {
            System.out.println("Process: processEmptyNodeSomeList");
            resultObject = putIfEmptyNodeSomeList(node, bucketSearched);
        }
        return resultObject;
    }

    private Driver putIfEmptyNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("Original node state: " + bucketSearched.getNode());
        bucketSearched.setNode(node);
        System.out.println("Bucket state: " + bucketSearched);
        System.out.println("bucketList: " + bucketList);
        return null;
    }

    private Driver putIfFullNodeEmptyList(Node node, Bucket bucketSearched) {
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

    private Driver putIfEmptyNodeSomeList(Node node, Bucket bucketSearched) {
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
        //return bucketList;
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
        Car carFromMainMethod = (Car) key;
        Driver objectDriver = checkBucket(bucketList.get(carFromMainMethod.hashCode() % mapSize), carFromMainMethod);
        System.out.println("Info from get method: ");
        System.out.println(carFromMainMethod.hashCode());
        System.out.println(mapSize);
        System.out.println("bucket: " + bucketList.get(carFromMainMethod.hashCode() %  mapSize));
        System.out.println();
        if (objectDriver != null) {
            return objectDriver;
        }
/*       for (int i = 0; i < bucketList.size(); i++) {
            objectDriver = checkBucket(bucketList.get(i), car);
            if (objectDriver != null) {
                return objectDriver;
            }
        }*/
        System.out.println("objectDriver 2: " + objectDriver);
        return objectDriver;
    }

    private Driver checkBucket(Bucket bucketSearched, Car carFromMainMethod) {
        Driver checkBucketObject = null;
        if (bucketSearched.getNode() != null) {
            System.out.println("bucketSearched.getNode()" + bucketSearched.getNode());
            System.out.println(carFromMainMethod.hashCode());
            System.out.println(carFromMainMethod.getId());
            System.out.println(bucketSearched.getNode().getCar().hashCode());
            System.out.println(bucketSearched.getNode().getCar().getId());
            if (carFromMainMethod.equals(bucketSearched.getNode().getCar())) {
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
                if (carFromMainMethod.equals(bucketSearched.getNodeList().get(i).getCar())) {
                    System.out.println("The object is found in the nodeList: " +
                            bucketSearched.getNodeList().get(i).getCar() + " " +
                            bucketSearched.getNodeList().get(i).getDriver() +
                            " bucketIndex" + bucketSearched.getIndex());
                    checkBucketObject = (Driver) bucketSearched.getNodeList().get(i).getDriver();
                    System.out.println("checkBucketObject: " + checkBucketObject);
                }
            }
            System.out.println("bucketSearched.getNodeList()" + bucketSearched.getNodeList());
        }
        System.out.println("checkBucketObject: " + checkBucketObject);
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


/*            if(bucketList.get(i).getNode().getCar() != null *//*|| key.equals(bucketList.get(i).getNode().getCar())*//*) {
                System.out.println();
                objectDriver = bucketList.get(i).getNode().getDriver();
            }*/
/*            for (int j = 0; j < bucketList.get(i).getNodeList().size(); j++) {
                if(key.equals(bucketList.get(i).getNode().getCar())) {
                    objectDriver = (Driver) bucketList.get(i).getNodeList().get(j).getDriver();
                }
            }*/
//System.out.println("Hello!");











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
