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

    public HashMap put(Node node) {
        getBucketNumber(node);
        findTheBucketSearched(bucketList);
        System.out.println();
        checkNodesInTheBucketSearched(bucketSearched);
        putNode(checkNodesResult, node);

        return null;
    }


    private int getBucketNumber(Node node) {
        hashCodeValue = node.getCar().hashCode();
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

    private void putNode(int checkNodesResult, Node node) {
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

    public List<Bucket> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Bucket> bucketList) {
        this.bucketList = bucketList;
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


