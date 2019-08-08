package com.granovskiy;

import java.util.List;

public class Bucket<E> {
    private Entry<Car, Driver> entry;
    private int bucketSize;
    private List<Entry> bucketList;

    public Bucket(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public Entry<Car, Driver> getEntry() {
        return entry;
    }

    public void setEntry(Entry<Car, Driver> entry) {
        this.entry = entry;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public List<Entry> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Entry> bucketList) {
        this.bucketList = bucketList;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "entry=" + entry +
                //", bucketList=" + bucketList +    //   = null  ???
                '}';
    }
}
