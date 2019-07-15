package com.granovskiy;

import java.util.Arrays;

public class MyHashMap {

    private final int DEFAULT_CAPACITY = 16;
    private float loadFactor;
    private int size;
    private MyEntry<Integer, Long>[] table;

    public MyHashMap() {
        table = new MyEntry[DEFAULT_CAPACITY];
        this.loadFactor = 0.75f;
    }

    public MyHashMap(int capacity) {
        table = new MyEntry[capacity];
        this.loadFactor = 0.75f;
    }

    public MyHashMap(int capacity, float loadFactor) {
        table = new MyEntry[capacity];
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public Long get(Integer key) {
        MyEntry<Integer, Long> entry;
        if (key == null) {
            entry = table[0];
            if (entry != null) {
                return entry.getValue();
            }
        } else {
            int location = index(key.hashCode());
            entry = table[location];
            if (entry != null && entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Long put(Integer key, Long value) {
        Long returnValue = null;
        if (key == null) {
            returnValue = putForNullKey(value);
        } else {
            int location = index(key.hashCode());
            MyEntry<Integer, Long> entry;

            MyEntry<Integer, Long> newEntry = new MyEntry<>();
            newEntry.setKey(key);
            newEntry.setValue(value);

            for (int i = location; i < table.length; i++) {
                entry = table[i];
                if (entry != null) {
                    returnValue = entry.getValue();
                    if (entry.getKey().equals(key)) {
                        table[i] = newEntry;
                    }
                } else {
                    table[i] = newEntry;
                    size++;
                    increaseCapacity();
                    break;
                }
            }
        }
        return returnValue;
    }

    private int index(int hash) {
        return hash % table.length;
    }

    private Long putForNullKey(Long value) {
        Long returnValue = null;
        MyEntry<Integer, Long> entry = table[0];
        if (entry != null && entry.getKey() == null) {
            returnValue = entry.getValue();
            entry.setValue(value);
        } else {
            MyEntry<Integer, Long> newEntry = new MyEntry<>();
            newEntry.setKey(null);
            newEntry.setValue(value);
            table[0] = newEntry;
            size++;
            increaseCapacity();
        }
        return returnValue;
    }

    private void increaseCapacity() {
        if (size >= table.length * loadFactor) {
            int newCapacity = table.length * 2;
            transfer(newCapacity);
        }
    }

    private void transfer(int capacity) {
        MyEntry<Integer, Long>[] tempTable = Arrays.copyOf(table, table.length);
        table = new MyEntry[capacity];
        size = 0;
        for (int i = 0; i < tempTable.length; i++) {
            MyEntry<Integer, Long> entry = tempTable[i];
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
