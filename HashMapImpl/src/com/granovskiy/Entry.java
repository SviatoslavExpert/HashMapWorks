package com.granovskiy;

import java.util.Objects;

public class Entry<K,V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?, ?> that = (Entry<?, ?>) o;
        return Objects.equals(getKey(), that.getKey()) &&
                Objects.equals(getValue(), that.getValue()) &&
                getNext().equals(that.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue(), getNext());
    }

    @Override
    public String toString() {
        return "HashMapEntry{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}


