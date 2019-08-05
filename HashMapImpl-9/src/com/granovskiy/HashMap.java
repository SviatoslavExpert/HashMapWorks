package com.granovskiy;

public class HashMap<Car, Driver> {
    private final int DEFAULT_CAPACITY = 16;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    //List<Entry> hash_map;
    //HashMap<Entry> hashMapEntry;
    //Entry[] hash_map;
    Entry<Car, Driver> entry;

    public HashMap(Entry<Car, Driver> entry) {
        this.entry = entry;
    }


    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public float getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    public Entry<Car, Driver> getEntry() {
        return entry;
    }

    public void setEntry(Entry<Car, Driver> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", DEFAULT_LOAD_FACTOR=" + DEFAULT_LOAD_FACTOR +
                ", size=" + size +
                ", entry=" + entry +
                '}';
    }
}
