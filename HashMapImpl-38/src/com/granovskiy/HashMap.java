package com.granovskiy;

import java.util.*;
import java.lang.Object;

public class HashMap implements Map {
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

    public Object put(Object key, Object value) {
        int bucketNumber = getbucketNumber(key, value);
        Bucket bucketSearched = findTheBucketSearched(bucketList, bucketNumber, key, value);
        return processNode(bucketSearched, key, value);
    }

    private int getbucketNumber(Object key, Object value) {
        int hashCodeValue = key.hashCode();
        int bucketNumberValue = hashCodeValue % mapSize;
        System.out.println();
        System.out.print("bucketNumber: " + bucketNumberValue + ", ");
        return bucketNumberValue;
    }

    private Bucket findTheBucketSearched(List<Bucket> bucketList, int bucketNumber, Object key, Object value) {
        return bucketList.get(bucketNumber);
    }

    private Object processNode(Bucket bucketSearched, Object key, Object value){
        Object resultObject = null;
        Node node = new Node(key, value);
        if(bucketSearched.getNode() == null && bucketSearched.getNodeList().isEmpty()) {
            resultObject = processEmptyNodeEmptyList(node, bucketSearched);
        }
        if(bucketSearched.getNode() != null && bucketSearched.getNodeList().isEmpty()) {
            resultObject = processFullNodeEmptyList(node, bucketSearched);
        }
        if(bucketSearched.getNode() == null && !bucketSearched.getNodeList().isEmpty()) {
            resultObject = processEmptyNodeSomeList(node, bucketSearched);
        }
        return resultObject;
    }

    private Object processEmptyNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("bucketSearched.getNode()0: " + bucketSearched.getNode());
        bucketSearched.setNode(node);
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
        return null;
    }

    private Object processFullNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("bucketSearched.getNode() 1 previous: " + bucketSearched.getNode());  //    !!!
        Node previousNode = bucketSearched.getNode();
        bucketSearched.getNodeList().add(0, previousNode);
        bucketSearched.getNodeList().add(1, node);
        bucketSearched.setNode(null);    //    !!!!!
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
        return null;
    }

    private Object processEmptyNodeSomeList(Node node, Bucket bucketSearched) {
        bucketSearched.getNodeList().add(node);
        bucketSearched.setNode(null);    //    !!!!!
        return null;
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

/*    @Override
    public Object put(Object key, Object value) {
        return null;
    }*/

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
