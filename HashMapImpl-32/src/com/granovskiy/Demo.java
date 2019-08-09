package com.granovskiy;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        //Operations operations = new Operations();
        Bucket bucket = new Bucket();

        Method m = Bucket.class.getDeclaredMethod("start");  // Using getDeclareMethod() method
        m.setAccessible(true);    // Using setAccessible() method
        m.invoke(bucket);   // Using invoke() method
    }
}
