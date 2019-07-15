package com.granovskiy;

public class MyEntry<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().getName().equals(o.getClass().getName())) {
            return false;
        }
        MyEntry e = (MyEntry) o;
        if (this.key == e.key) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int mul = 11;
        if (key != null) {
            return prime * mul + key.hashCode();
        }
        return 0;
    }
}
