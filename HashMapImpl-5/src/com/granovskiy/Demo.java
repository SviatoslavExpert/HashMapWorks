package com.granovskiy;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        //  making objects
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Car car4 = new Car(4);
        Car car5 = new Car(5);
        Car car6 = new Car(6);
        Car car7 = new Car(7);
        Car car8 = new Car(8);
        Car car9 = new Car(9);
        Car car10 = new Car(10);
        Car car11 = new Car(11);
        Driver driver1 = new Driver("Mike");
        Driver driver2 = new Driver("Ted");
        Driver driver3 = new Driver("John");
        Driver driver4 = new Driver("Martha");
        Driver driver5 = new Driver("Linda");
        Driver driver6 = new Driver("Sue");
        Driver driver7 = new Driver("Bob");
        Driver driver8 = new Driver("Margo");
        Driver driver9 = new Driver("Phil");
        Driver driver10 = new Driver("Mark");
        Driver driver11 = new Driver("Steve");

        int mapSize = 16;
        Entry<Car, Driver> entry1 = new Entry<>(car1, driver1);
        Entry<Car, Driver> entry2 = new Entry<>(car2, driver2);
        Entry<Car, Driver> entry3 = new Entry<>(car3, driver3);
        Entry<Car, Driver> entry4 = new Entry<>(car4, driver4);
        Entry<Car, Driver> entry5 = new Entry<>(car5, driver5);
        Entry<Car, Driver> entry6 = new Entry<>(car6, driver6);
        Entry<Car, Driver> entry7 = new Entry<>(car7, driver7);
        Entry<Car, Driver> entry8 = new Entry<>(car8, driver8);
        Entry<Car, Driver> entry9 = new Entry<>(car9, driver9);
        Entry<Car, Driver> entry10 = new Entry<>(car10, driver10);
        Entry<Car, Driver> entry11 = new Entry<>(car11, driver11);

        //  getting the bucket numbers
        int bucketNumber1 = car1.hashCode() % mapSize;
        int bucketNumber2 = car2.hashCode() % mapSize;
        int bucketNumber3 = car3.hashCode() % mapSize;
        int bucketNumber4 = car4.hashCode() % mapSize;
        int bucketNumber5 = car5.hashCode() % mapSize;
        int bucketNumber6 = car6.hashCode() % mapSize;
        int bucketNumber7 = car7.hashCode() % mapSize;
        int bucketNumber8 = car8.hashCode() % mapSize;
        int bucketNumber9 = car9.hashCode() % mapSize;
        int bucketNumber10 = car10.hashCode() % mapSize;
        int bucketNumber11 = car11.hashCode() % mapSize;

        System.out.println("hashCode1 : " + car1.hashCode() + " , " + "bucketNumber : " + (bucketNumber1 + 1));
        System.out.println("hashCode2 : " + car2.hashCode() + " , " + "bucketNumber : " + (bucketNumber2 + 1));
        System.out.println("hashCode3 : " + car3.hashCode() + " , " + "bucketNumber : " + (bucketNumber3 + 1));
        System.out.println("hashCode4 : " + car4.hashCode() + " , " + "bucketNumber : " + (bucketNumber4 + 1));
        System.out.println("hashCode5 : " + car5.hashCode() + " , " + "bucketNumber : " + (bucketNumber5 + 1));
        System.out.println("hashCode6 : " + car6.hashCode() + " , " + "bucketNumber : " + (bucketNumber6 + 1));
        System.out.println("hashCode7 : " + car7.hashCode() + " , " + "bucketNumber : " + (bucketNumber7 + 1));
        System.out.println("hashCode8 : " + car8.hashCode() + " , " + "bucketNumber : " + (bucketNumber8 + 1));
        System.out.println("hashCode9 : " + car9.hashCode() + " , " + "bucketNumber : " + (bucketNumber9 + 1));
        System.out.println("hashCode10 : " + car10.hashCode() + " , " + "bucketNumber : " + (bucketNumber10 + 1));
        System.out.println("hashCode11 : " + car11.hashCode() + " , " + "bucketNumber : " + (bucketNumber11 + 1));

        //HashMap<Car, Driver> hash_map = new HashMap<>(mapSize, car1, driver1);
        //System.out.println(hash_map);

        HashMap<Car, Driver> hash_map = new HashMap<>();
        hash_map.put(car1, driver1);
        System.out.println(hash_map);
    }

    public static class Bucket {

    }
}







//HashMap<Entry> hash_map = new HashMap<Entry>(mapSize, entry1);
//Entry[] carArray = new Entry[2];

//List<Car, Driver> a = new ArrayList<>();
//carArray[0] = car1;
//Entry entry = new Entry(int[car1, driver1] arr);
