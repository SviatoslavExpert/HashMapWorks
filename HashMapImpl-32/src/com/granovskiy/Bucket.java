package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Node<Car, Driver> node;
    private int index;
    private int bucketSize = 16;
    private List<Node> bucketList = new ArrayList<Node>(16);

    public boolean checkIfBucketIsEmpty(List<Node> bucketList){
        System.out.println(!bucketList.isEmpty());
        return !bucketList.isEmpty();
    }


    //  в методі addEntry якщо size 0, тоді пишемо в node - bucket
    public List<Node> addEntry(Node<Car, Driver> node) {
        if(bucketSize == 0) {
            bucketList.add(node);
            System.out.println(bucketList);
        }
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
