package com.granovskiy;

import java.util.Random;

public class RandomNumbers {
    public static int generateRandomInt() {
        Random r = new Random();
        int v = r.nextInt();
        return v;
    }

    public static long generateRandomLong() {
        // create random object
        Random random = new Random();
        // get next long value
        long value = random.nextLong();
        return value;
    }
}
