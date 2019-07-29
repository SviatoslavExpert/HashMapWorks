package com.granovskiy;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, Long> numbers = new HashMap<>();
        int size = 3;
        for (int i = 0; i < size; i++) {
            numbers.put(new Random().nextInt(), new Random().nextLong());
        }
        System.out.println(numbers);
        for (Map.Entry number : numbers.entrySet()) {
            System.out.println(number.getKey() + " " + number.getValue());
        }
        System.out.println();

        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Mike");
        students.put(2, "Tina");
        students.put(3, "Ted");
        System.out.println("Initial list of students: " + students);

        students.remove(2);
        System.out.println("The list after one student is removed: " + students);

        students.replace(3, "Linda");
        System.out.println("The list after one student is replaced: " + students);

        students.replaceAll((k, v) -> "John");
        System.out.println("New list of students: " + students);
        System.out.println();

        Map<Integer,Car> cars = new HashMap<>();
        cars.put(1, (new Car(2, "Honda", 30000)));
        cars.put(7, (new Car(5, "Toyota", 50000)));
        cars.put(12, (new Car(7, "Mazda", 45000)));
        System.out.println(cars);

        cars.replaceAll((k, v) -> new Car(9, "Lexus", 70000));
        System.out.println(cars);
        System.out.println();

        cars.replace(7, new Car(11, "Volvo", 60000));
        System.out.println(cars);


    }
}
