package com.granovskiy;

import java.util.List;

public class HashMap {
    public static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_LOAD_FACTOR = 75;
    private int size;
    //List<Entry> hash_map;
    //HashMap<Entry> hashMapEntry;
    //Entry[] hash_map;

    private List<Entry> entries;

    public HashMap(List<Entry> entries) {
        this.entries = entries;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public int getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", DEFAULT_LOAD_FACTOR=" + DEFAULT_LOAD_FACTOR +
                ", size=" + size +
                ", entries=" + entries +
                '}';
    }
}
