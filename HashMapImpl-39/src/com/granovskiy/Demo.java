package com.granovskiy;

public class Demo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.makeEmptyHashMap();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            Object key = new Object();
            Object value = new Object();
            hashMap.put(key, value);
            System.out.println();
            System.out.println(hashMap);
        }
    }
}
