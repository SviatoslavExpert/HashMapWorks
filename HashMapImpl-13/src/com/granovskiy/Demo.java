package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int mapSize = HashMap.DEFAULT_CAPACITY;
        String[] driverNames =
                {"Mike", "Ted", "John", "Martha", "Linda", "Sue", "Bob",
                        "Margo", "Phil", "Mark", "Steve", "Karl", "Belinda",
                        "Mary", "Teresa", "Suzanne", "Tom", "Rose", "Anna",
                        "Tina", "Jessica", "Becky", "Louisa", "Margo", "Nelly",
                        "Tina", "Jessica", "Becky", "Louisa", "Margo", "Nelly"};

        List<List<Entry>> entries = new ArrayList<>(mapSize);  //  List of entries !!!!!
        for (int i = 0; i < mapSize; i++) {
            entries.add(null);
        }
        System.out.println(entries);

        HashMap hashMap1 = new HashMap(entries);
        fillHashMap(mapSize, driverNames, entries, hashMap1);
        System.out.println("==================================");
        System.out.println(hashMap1);
    }

    public static void fillHashMap(int mapSize, String[] driverNames, List<List<Entry>> entries, HashMap hashMap1) {
        int bucketNumber;
        for (int i = 0; i < mapSize + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(driverNames[i]);
            bucketNumber = car.hashCode() % mapSize;
            if(bucketNumber <= mapSize) {
                System.out.println("BucketNumber: " + bucketNumber);
                Entry<Car, Driver> entry = new Entry<>(car, driver);
                List<Entry> innerEntryList = new ArrayList<>(mapSize);
                innerEntryList.add(entry);

                entries.add(bucketNumber, innerEntryList);              //  Each entry is added to the list !!!!!
                if (checkLoading(hashMap1, mapSize) == mapSize * hashMap1.getDEFAULT_LOAD_FACTOR() / 100) {
                    mapSize = mapSize * 2;
                    System.out.println("The load factor is reached.");
                    System.out.println("New map size: " + mapSize);
                    return;
                }
            }
        }
    }

    public static int checkLoading(HashMap hashMap1, int mapSize) {
        int count = 0;
        for (int i = 0; i < mapSize; i++) {
            if(hashMap1.getEntries().get(i) != null) {
                count++;
            }
        }
        System.out.println("The count is: " + count);
        System.out.println();
        return count;
    }
}
