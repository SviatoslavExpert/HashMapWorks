package com.granovskiy;

import java.util.HashMap;

import static com.granovskiy.RandomNumbers.generateRandomInt;
import static com.granovskiy.RandomNumbers.generateRandomLong;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, Long> numbers = new HashMap<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            numbers.put(generateRandomInt(), generateRandomLong());
        }

        System.out.println(numbers);
        //System.out.println(numbers.get(2));
    }
}
