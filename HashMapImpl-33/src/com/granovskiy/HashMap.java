package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize;
    private Bucket bucket;
    private List<Bucket> bucketList = new ArrayList<>(DEFAULT_CAPACITY);  // entriesContainer initialized

    //  MY METHODS
    public void makeEmptyHashMap() {
        HashMap hm = new HashMap();
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            bucketList.add(null);
        }
        System.out.println("bucketList: " + bucketList);  //  entriesContainer
        System.out.println();
        //fillHashMap(hm, entriesContainer, mapSize);
    }
}





/*    public void createEmptyHashMap() {
        for(int i = 0;i<DEFAULT_CAPACITY;i++){
            bucket = new Bucket();
            bucketList.add(bucket);
        }
        System.out.println(bucketList);
    }*/
