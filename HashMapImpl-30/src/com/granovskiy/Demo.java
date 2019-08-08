package com.granovskiy;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        Operations operations = new Operations();
        Method m = Operations.class.getDeclaredMethod("makeEntries");  // Using getDeclareMethod() method
        m.setAccessible(true);    // Using setAccessible() method
        m.invoke(operations);   // Using invoke() method
    }
}
