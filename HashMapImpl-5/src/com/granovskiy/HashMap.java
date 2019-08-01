package com.granovskiy;

import java.util.Arrays;
import java.util.List;

public class HashMap<Entry> {
    private final int DEFAULT_CAPACITY = 16;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    //List<Entry> hash_map;
    Entry[] hash_map;

    public HashMap(int size, Entry[] hash_map) {
        this.size = size;
        this.hash_map = hash_map;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public float getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Entry[] getHash_map() {
        return hash_map;
    }

    public void setHash_map(Entry[] hash_map) {
        this.hash_map = hash_map;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", DEFAULT_LOAD_FACTOR=" + DEFAULT_LOAD_FACTOR +
                ", size=" + size +
                ", hash_map=" + Arrays.toString(hash_map) +
                '}';
    }
}
