package com.granovskiy;

public class Demo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Provider provider = new Provider();
        hashMap.makeEmptyHashMap();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(provider.getDriverNames()[i]);
            //Node node = new Node(car, driver);
            hashMap.put(car, driver);
            System.out.println();
            System.out.println(hashMap);
        }
    }
}
