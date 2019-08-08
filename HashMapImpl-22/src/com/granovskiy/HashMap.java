package com.granovskiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        //HashMap hm = new HashMap(mapSize);
        for (int i = 0; i < mapSize; i++) {
            entriesContainer.add(null);
        }

        System.out.println("entriesContainer: " + entriesContainer);  //  entriesContainer
        System.out.println("hashMap: ");
        System.out.println();
        prepareToFillHashMap(entriesContainer, mapSize);
    }

    private void prepareToFillHashMap(List<Bucket<Entry<Car, Driver>>> entriesContainer, int mapSize) {
        int bucketNumber;
        int hashCodeValue;
        int i;
        Provider provider = new Provider();
        for (i = 0; i < mapSize + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(provider.getDriverNames()[i]);
            hashCodeValue = car.hashCode();
            bucketNumber = hashCodeValue % mapSize;
            fillHashMap(car, driver, bucketNumber, hashCodeValue, i);
        }
    }

    private void fillHashMap(Car car, Driver driver, int bucketNumber, int hashCodeValue, int i) {
        // check if a bucket with such number already exists (iterate entriesContainer)
        //if yes, add entry to the bucket
        // if not, we create a new bucket
        for (int j = 0; j < entriesContainer.size(); j++) {
            //bucketNumber == entriesContainer.get(j).getBucketList();
        }
        Bucket<Entry<Car, Driver>> bucket = new Bucket(14);      //  bucket  initialized
        int bucketSize = bucket.getBucketSize();
        if (bucketNumber <= mapSize) {
            System.out.println("BucketNumber: " + bucketNumber);
            Entry<Car, Driver> entry = new Entry<>(car, driver);
            System.out.println("entry: " + entry);
            bucket.setEntry(entry);         //  the entry is in bucket but it is not in the bucketList
            bucketList.add(entry);
            System.out.println("bucket" + bucketNumber + ": " + bucket);
            //   create new list
            //   add new entry to the list
            //   initialize bucketlist with the created list

            //   in the future we add entries to the bucketlist


            entriesContainer.add(bucketNumber, bucket);              //  Each entry is added to the list !!!!!
            System.out.println("entriesContainer: " + entriesContainer);
            System.out.println("=====================");
            if(checkIfBucketNumberWasUsed(bucketNumber, bucket, bucketSize)) {
                System.out.println();
                if(checkIfCollisionIs(entry, bucket, hashCodeValue, bucketSize, i)) {
                    //  replace the previous object
                    //bucket.setEntry(entry);

                } else {
                    //  add to the bucket as next object
                }
            }
            System.out.println();

                /*if (countFilledSpaces(hm, mapSize) == mapSize * hm.getDEFAULT_LOAD_FACTOR() / 100) {
                    mapSize = mapSize * 2;
                    System.out.println("The load factor is reached.");
                    System.out.println("New map size: " + mapSize);
                    return;
                }*/
        }
    }

    private boolean checkIfBucketNumberWasUsed(int bucketNumber, Bucket<Entry<Car, Driver>> bucket, int bucketSize) {
        boolean booleanFlag= false;
        for (int i = 0; i < mapSize; i++) {
            if(entriesContainer.get(i) != null) {
                System.out.print("BucketNumber Was Used.  ");
                booleanFlag = true;
            } else {
                System.out.print("BucketNumber Was Not Used.  ");
                booleanFlag = false;
            }
        }
        return booleanFlag;
    }

    private boolean checkIfCollisionIs(Entry<Car, Driver> entry, Bucket<Entry<Car, Driver>> bucket, int hashCodeValue, int bucketSize, int i) {
        boolean isFlag = false;
        for (int k = 0; k < i; k++) {
            if(hashCodeValue == entry.getCar().hashCode()) {
                System.out.print("Collision is.");
                isFlag = true;
            } else {
                System.out.print("No collision.");
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

