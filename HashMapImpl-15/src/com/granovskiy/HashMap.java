package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
    public static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int mapSize = HashMap.DEFAULT_CAPACITY;
    String[] driverNames =
            {"Mike", "Ted", "John", "Martha", "Linda", "Sue", "Bob",
                    "Margo", "Phil", "Mark", "Steve", "Karl", "Belinda",
                    "Mary", "Teresa", "Suzanne", "Tom", "Rose", "Anna",
                    "Tina", "Jessica", "Becky", "Louisa", "Margo", "Nelly",
                    "Tina", "Jessica", "Becky", "Louisa", "Margo", "Nelly"};
    //List<List<Entry>> entries;
    List<List<Entry>> entriesContainer = new ArrayList<>();  //  List of entries !!!!!

    public HashMap(int mapSize) {
        this.mapSize = mapSize;
    }

    public HashMap(List<List<Entry>> entriesContainer) {
        this.entriesContainer = entriesContainer;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public int getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    public List<List<Entry>> getEntries() {
        return entriesContainer;
    }

    public void setEntries(List<List<Entry>> entries) {
        this.entriesContainer = entriesContainer;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public List<List<Entry>> getEntriesContainer() {
        return entriesContainer;
    }

    public void setEntriesContainer(List<List<Entry>> entriesContainer) {
        this.entriesContainer = entriesContainer;
    }

    //  MY METHODS
    void makeEmptyEntriesContainer() {
        List<List<Entry>> entriesContainer = new ArrayList<>(HashMap.DEFAULT_CAPACITY);  //  List of entries !!!!!
        for (int i = 0; i < HashMap.DEFAULT_CAPACITY; i++) {
            entriesContainer.add(null);
        }
        System.out.println("entriesContainer: " + entriesContainer);  //  entriesContainer
        makeEmptyHashMap(entriesContainer);
        System.out.println();
        //return entriesContainer;
    }

    private void makeEmptyHashMap(List<List<Entry>> entriesContainer) {
        HashMap hm = new HashMap(entriesContainer);
        for (int i = 0; i < mapSize; i++) {
            entriesContainer.add(null);
        }
        System.out.println("hashMap: " + hm);
        System.out.println();

        fillHashMap(hm, entriesContainer, mapSize);
    }

    private void fillHashMap(HashMap hm, List<List<Entry>> entriesContainer, int mapSize) {
        int bucketNumber;
        for (int i = 0; i < mapSize + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(hm.driverNames[i]);
            bucketNumber = car.hashCode() % mapSize;
            if (bucketNumber <= mapSize) {
                System.out.println("BucketNumber: " + bucketNumber);
                Entry<Car, Driver> entry = new Entry<>(car, driver);
                System.out.println("entry: " + entry);
                List<Entry> innerEntryList = new ArrayList<>(mapSize);
                innerEntryList.add(entry);
                System.out.println("innerEntryList " + innerEntryList);
                entriesContainer.add(bucketNumber, innerEntryList);              //  Each entry is added to the list !!!!!
                System.out.println("=====================");
                System.out.println(entriesContainer);
                if (countFilledSpaces(hm, mapSize) == mapSize * hm.getDEFAULT_LOAD_FACTOR() / 100) {
                    mapSize = mapSize * 2;
                    System.out.println("The load factor is reached.");
                    System.out.println("New map size: " + mapSize);
                    return;
                }
            }
        }
    }

    private int countFilledSpaces(HashMap hm, int mapSize) {
        int count = 0;
        for (int i = 0; i < mapSize; i++) {
            if (hm.getEntries().get(i) != null) {
                count++;
            }
        }
        System.out.println("The count is: " + count);
        System.out.println();
        return count;
    }


    @Override
    public String toString() {
        return "HashMap{" +
                "entriesContainer=" + entriesContainer +
                '}';
    }
}
