package com.granovskiy;

public class Demo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Provider provider = new Provider();
        hashMap.makeEmptyHashMap(hashMap.getDefaultCapacity());
        System.out.println();
        for (int i = 0; i < 30; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(provider.getDriverNames()[i]);
            System.out.println("Method put returns: " + hashMap.put(car, driver));
            System.out.println();
        }
        Car car1 = new Car(120);
        System.out.println("car1.hashCode(): " + car1.hashCode());
        System.out.println("Method get returns: " + hashMap.get(car1));
    }
}
