package com.granovskiy;

public class Demo {
    public static void main(String[] args) {

        /*HashMap hashMap = new HashMap<>();
        Entry<String,String> entry = new Entry<>();
        //HashMap.put("USA", "Washington DC");
        hashMap.put("Canada", "Toronto");
        System.out.println(hashMap.get("USA"));
        System.out.println(hashMap.get("Canada"));
        System.out.println(hashMap.size());
        System.out.println(hashMap);
        hashMap.put("Spain", "Madrid");
        hashMap.put("Italy", "Rome");
        hashMap.put("France", "Paris");
        hashMap.put("Germany", "Berlin");
        hashMap.put("China", "Beijing");
        hashMap.put("Ukraine", "Kyiv");
*//*        hashMap.put("The Netherlands", "Amsterdam");
        hashMap.put("The UK", "London");
         hashMap.put("Egypt", "Cairo");
        hashMap.put("Turkey", "Istanbul");
        hashMap.put("Japan", "Tokyo");*//*
        System.out.println(hashMap.size());
        System.out.println(hashMap);
        //System.out.println(Entry.hashCode("Spain"));
        System.out.println(entry.hashCode());*/



        //HashMap <K, V> carHashMap = new HashMap<K, V>();


        Car car1 = new Car(1);
        Driver driver1 = new Driver("Mike");

        Entry<Car car, Driver driver> carEntry = new Entry<Car car, Driver driver>();
        int hashCodeValue1 = car1.hashCode();
        System.out.println(hashCodeValue1);



    }
}
