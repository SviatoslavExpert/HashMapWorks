package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Node<Car, Driver> node;
    private int bucketSize;
    private List<Node> bucketList = new ArrayList<>(bucketSize);

    public Bucket(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public Bucket(int bucketSize, List<Node> bucketList) {
        this.bucketSize = bucketSize;
        this.bucketList = bucketList;
    }

    public List<Node> addEntry(Node<Car, Driver> node) {
        bucketList.add(node);
        return bucketList;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public List<Node> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Node> bucketList) {
        this.bucketList = bucketList;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "bucketList=" + bucketList +
                '}';
    }
}
