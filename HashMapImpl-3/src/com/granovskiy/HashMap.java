package com.granovskiy;

import java.util.Arrays;

public class HashMap<K, V> {
    private final int DEFAULT_CAPACITY = 16;
    private final float loadFactor = 0.75f;
    private int mapSize;
    private Entry<K, V>[] table;

    public HashMap(int mapSize, Entry<K, V>[] table) {
        this.mapSize = mapSize;
        this.table = table;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public void setTable(Entry<K, V>[] table) {
        this.table = table;
    }

    /*
      public int size() {
          return size;
      }
   */

    public V  t(K key) {
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
            Entry<K, V> entry;

            Entry<K, V> newEntry = new Entry<>();
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
                    mapSize++;
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
            mapSize++;
            increaseCapacity();
        }
        return returnValue;
    }

    private void increaseCapacity() {
        if (mapSize >= table.length * loadFactor) {
            int newCapacity = table.length * 2;
            transfer(newCapacity);
        }
    }

    private void transfer(int capacity) {
        Entry<K, V>[] tempTable = Arrays.copyOf(table, table.length);
        table = new Entry[capacity];
        mapSize = 0;
        for (int i = 0; i < tempTable.length; i++) {
            Entry<K, V> entry = tempTable[i];
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", loadFactor=" + loadFactor +
                ", size=" + mapSize +
                ", table=" + Arrays.toString(table) +
                '}';
    }
}
