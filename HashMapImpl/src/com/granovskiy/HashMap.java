package com.granovskiy;

public class HashMap<K, V> {
    private final int DEFAULT_CAPACITY = 16;
    private float loadFactor;
    private int size;
    private Entry<K, V>[] table;

    public HashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        this.loadFactor = 0.75f;
    }

    public HashMap(int capacity) {
        table = new Entry[capacity];
        this.loadFactor = 0.75f;
    }

    public HashMap(int capacity, float loadFactor) {
        table = new Entry[capacity];
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Entry<K, V> entry;
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

    public V put(K key, V value) {
        V returnValue = null;
        if (key == null) {
            returnValue = putForNullKey(value);
        } else {
            int location = index(key.hashCode());
            Entry<Integer, Long> entry;

            Entry<Integer, Long> newEntry = new Entry<>();
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

    private V putForNullKey(V value) {
        V returnValue = null;
        Entry<K, V> entry = table[0];
        if (entry != null && entry.getKey() == null) {
            returnValue = entry.getValue();
            entry.setValue(value);
        } else {
            Entry<K, V> newEntry = new Entry<>();
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

}
