package com.granovskiy;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        HashMap hashMap = new HashMap(16);
        Method m = HashMap.class.getDeclaredMethod("makeEmptyHashMap");  // Using getDeclareMethod() method
        m.setAccessible(true);    // Using setAccessible() method
        m.invoke(hashMap);   // Using invoke() method
    }
}
