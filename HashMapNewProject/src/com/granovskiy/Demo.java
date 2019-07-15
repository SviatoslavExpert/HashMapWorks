package com.granovskiy;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        System.out.println();
        System.out.println("The key is England, the value is: " + capitalCities.get("England"));
        capitalCities.remove("England");
        System.out.println();
        System.out.println(capitalCities);
        capitalCities.clear();
        System.out.println();
        System.out.println(capitalCities);
        System.out.println();
        capitalCities.put("Italy", "Rome");
        capitalCities.put("Spain", "Madrid");
        capitalCities.put("Ukraine", "Kyiv");
        capitalCities.put("China", "Beijing");
        capitalCities.put("Turkey", "Istanbul");
        System.out.println(capitalCities);
        System.out.println();
        System.out.println("The size:" + capitalCities.size());
        System.out.println();
        // Print keys
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        System.out.println();
        // Print values
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }
        // Print keys and values
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }

    }


}
