package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = DEFAULT_CAPACITY;
    private List<Bucket<Entry<Car, Driver>>> entriesContainer = new ArrayList<>(DEFAULT_CAPACITY);  // entriesContainer initialized
    //private EntriesContainer List<List<Entry>> entriesContainer;  // entriesContainer initialized

    public HashMap(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public int getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    //  MY METHODS
    private void makeEmptyHashMap() {
        HashMap hm = new HashMap(mapSize);
        for (int i = 0; i < mapSize; i++) {
            entriesContainer.add(null);
        }
        System.out.println("entriesContainer: " + entriesContainer);  //  entriesContainer
        System.out.println("hashMap: " + hm);
        System.out.println();
        fillHashMap(hm, entriesContainer, mapSize);
    }

    private void fillHashMap(HashMap hm, List<Bucket<Entry<Car, Driver>>> entriesContainer, int mapSize) {
        this.entriesContainer = entriesContainer;
        int bucketNumber;
        int hashCodeValue;
        Provider provider = new Provider();
        for (int i = 0; i < mapSize + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(provider.getDriverNames()[i]);
            hashCodeValue = car.hashCode();
            bucketNumber = hashCodeValue % mapSize;
            Bucket<Entry<Car, Driver>> bucket = new Bucket(14);      //  bucket  initialized
            int bucketSize = bucket.getBucketSize();
            if (bucketNumber <= mapSize) {
                System.out.println("BucketNumber: " + bucketNumber);
                Entry<Car, Driver> entry = new Entry<>(car, driver);
                System.out.println("entry: " + entry);
                bucket.setEntry(entry);
                System.out.println("bucket" + bucketNumber + ": " + bucket);


               entriesContainer.add(bucketNumber, bucket);              //  Each entry is added to the list !!!!!
                System.out.println("entriesContainer: " + entriesContainer);
                System.out.println("=====================");
                 if(checkIfBucketNumberWasUsed(bucketNumber, bucket, bucketSize)) {
                    if(checkIfCollisionIs(entry, bucket, hashCodeValue, bucketSize)) {
                        //  replace the previous object
                    } else {
                        //  add to the bucket as next object
                    }
                }

                /*if (countFilledSpaces(hm, mapSize) == mapSize * hm.getDEFAULT_LOAD_FACTOR() / 100) {
                    mapSize = mapSize * 2;
                    System.out.println("The load factor is reached.");
                    System.out.println("New map size: " + mapSize);
                    return;
                }*/
            }
        }
    }

    private boolean checkIfBucketNumberWasUsed(int bucketNumber, Bucket<Entry<Car, Driver>> bucket, int bucketSize) {
        boolean isBoolean = true;
        for (int i = 0; i < bucketSize; i++) {
            if(entriesContainer.get(i) != null) {
                isBoolean =  true;
                return isBoolean;
            } else {
                isBoolean = false;
            }
        }
        return isBoolean;
    }

    private boolean checkIfCollisionIs(Entry<Car, Driver> entry, Bucket<Entry<Car, Driver>> bucket, int hashCodeValue, int bucketSize) {
        boolean isFlag = true;
        for (int i = 0; i < bucketSize; i++) {
            if(hashCodeValue == entry.getCar().hashCode()) {
                isFlag = true;
                return isFlag;
            } else {
                isFlag = false;
            }
        }
        return isFlag;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "entriesContainer=" + entriesContainer +
                '}';
    }
}



    /*private int countFilledSpaces(HashMap hm, int mapSize) {
        int count = 0;
        for (int i = 0; i < mapSize; i++) {
            if (hm.getEntries().get(i) != null) {
                count++;
            }
        }
        System.out.println("The count is: " + count);
        System.out.println();
        return count;
    }*/


    //List<List<Entry>> entries;
    //List<List<Entry>> entriesContainer = new ArrayList<>();  //  List of entries !!!!!


//    public HashMap(List<List<Entry>> entriesContainer) {
//        this.entriesContainer = entriesContainer;
//    }

    /*    private void makeEmptyEntriesContainer() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            entriesContainer.add(null);
        }
        System.out.println("entriesContainer: " + entriesContainer);  //  entriesContainer
        makeEmptyHashMap(entriesContainer);
        System.out.println();
        //return entriesContainer;
    }*/

