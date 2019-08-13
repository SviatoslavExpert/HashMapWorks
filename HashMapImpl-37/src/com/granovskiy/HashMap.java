package com.granovskiy;

import java.util.*;

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

    //@Override
    public Object put(Object key, Object value) {
        int bucketNumber = getbucketNumber(key, value);
        Bucket bucketSearched = findTheBucketSearched(bucketList, bucketNumber, key, value);
        int checkNodesResult = checkNodesInTheBucketSearched(bucketSearched, key, value);
        putNode(checkNodesResult, key, value, bucketSearched);
        return null;
    }

    public int getbucketNumber(Object key, Object value) {
        int hashCodeValue = key.hashCode();
        int bucketNumberValue = hashCodeValue % mapSize;
        System.out.println();
        System.out.print("bucketNumber: " + bucketNumberValue + ", ");
        return bucketNumberValue;
    }

    private Bucket findTheBucketSearched(List<Bucket> bucketList, int bucketNumber, Object key, Object value) {
        return bucketList.get(bucketNumber);
    }

    private int checkNodesInTheBucketSearched(Bucket bucketSearched, Object key, Object value) {
        int checkNodesResultValue = 10;
        if (bucketSearched.getNode() == null && bucketSearched.getNodeList().isEmpty()) {
            checkNodesResultValue = 0;
        }
        if (bucketSearched.getNode() != null && bucketSearched.getNodeList().isEmpty()) {
            checkNodesResultValue = 1;
        }

        if (bucketSearched.getNode() == null && !bucketSearched.getNodeList().isEmpty()) {
            checkNodesResultValue = 2;
        }
        System.out.print("checkNodesResult: " + checkNodesResultValue + " ");
        //putNode(checkNodesResultValue, key, value, bucketSearched);
        return checkNodesResultValue;
    }

    private Node putNode(int checkNodesResult, Object key, Object value, Bucket bucketSearched) {
        Node node = new Node(key, value);
        Node nodeResult = null;
        if (checkNodesResult == 0) {
            nodeResult = processEmptyNodeEmptyList(node, bucketSearched);
        }
        if (checkNodesResult == 1) {
            //checkIfCollisionIs();
            nodeResult = processFullNodeEmptyList(node, bucketSearched);
        }
        if (checkNodesResult == 2) {
            //checkIfCollisionIs();
            nodeResult = processEmptyNodeSomeList(node, bucketSearched);
        }
        return nodeResult;
    }

    private Node processEmptyNodeEmptyList(Node node, Bucket bucketSearched) {
        System.out.println("bucketSearched.getNode()0: " + bucketSearched.getNode());
        System.out.print("My node: " + node);
        System.out.println();
        System.out.print(bucketSearched);
        return bucketSearched.setNode(node);
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(java.lang.Object key) {
        return false;
    }

    @Override
    public boolean containsValue(java.lang.Object value) {
        return false;
    }

    @Override
    public java.lang.Object get(java.lang.Object key) {
        return null;
    }

    @Override
    public java.lang.Object put(java.lang.Object key, java.lang.Object value) {
        return null;
    }

    @Override
    public java.lang.Object remove(java.lang.Object key) {
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

/*
    private boolean checkIfCollisionIs(Node node) {

    }
*/

}