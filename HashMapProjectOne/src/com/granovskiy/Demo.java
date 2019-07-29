package com.granovskiy;

import java.util.HashMap;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, Long> numbers = new HashMap<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            numbers.put(new Random().nextInt(), new Random().nextLong());
        }
        System.out.println(numbers);
    }
}
