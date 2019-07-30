package com.granovskiy;


public class HashMapEntry<K,V> {
        //final K key;
        V value;
        HashMapEntry<K,V> next;
        int hash;
        // Some utility methods

    final HashMapEntry<?,?>[] EMPTY_TABLE = {};
    HashMapEntry<K,V>[] table = (HashMapEntry<K,V>[]) EMPTY_TABLE;
    }

}
