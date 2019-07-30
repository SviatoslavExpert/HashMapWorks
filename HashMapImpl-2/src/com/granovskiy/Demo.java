package com.granovskiy;

public class Demo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap<>();
        hashMap.put("USA", "Washington DC");
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
        hashMap.put("The Netherlands", "Amsterdam");
       hashMap.put("The UK", "London");
/*         hashMap.put("Egypt", "Cairo");
        hashMap.put("Turkey", "Istanbul");
        hashMap.put("Japan", "Tokyo");*/
        System.out.println(hashMap.size());
        System.out.println(hashMap);
    }
}
