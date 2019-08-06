package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int mapSize = 11;
        Entry[] hashMap = new Entry[mapSize];
        System.out.println("==================================");

        int bucketNumber;
        String[] driverNames =
                {"Mike", "Ted", "John", "Martha", "Linda", "Sue", "Bob", "Margo", "Phil", "Mark", "Steve"};


        List<Car> innerCarList1 = new ArrayList<>();
        List<Driver> innerDriverList1 = new ArrayList<>();
        HashMap<Car, Driver> hashMap1 = new HashMap<>(new Entry<>(innerCarList1, innerDriverList1));

        for (int i = 0; i < mapSize; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(driverNames[i]);

            System.out.println("Car Object: " + car);
            System.out.println("HashCode: " + car.hashCode());
            bucketNumber = car.hashCode() % mapSize;
            System.out.println("BucketNumber: " + bucketNumber);
            //checkBucketNumber(bucketNumber);


            innerCarList1.add(car);

            innerDriverList1.add(driver);
            //Entry<Car, Driver> entry = new Entry<>(innerCarList1, innerDriverList1);
            System.out.println("hashMap1: " + hashMap1);
            System.out.println();
        }

        System.out.println("==================================");
        System.out.println(hashMap1);


/*        for (int i = 0; i < mapSize; i++) {
            System.out.println(hashMap1.getKey()+ + " ");
        }*/
        //   (hmse.getKey()+"\t"+hmse.getValue()
    }
}


/*            int a;
            A obj = new A();   // Creating the Object of class A
            a = obj.arr[0];    // calling the array arr from that object
            */

/*        public static int checkBucketNumber(int bucketNumber) {
            for(int i = 0; i < arr.length(); i++) {
                if (arr[i] = bucketNumber) {

                }
            }
        }*/


            /*Entry<Car, Driver> entry = new Entry<>(car, new Driver("Tim"));
            System.out.println("Entry: " + entry);
            hashMap[bucketNumber] = entry;*/




//Entry<Car, Driver> entry = new Entry<Car, Driver>(car, driver,0, innerCarList, innerDriverList);


/*            Car[] innerCarList = new Car[5];
            innerCarList[0] = car;*/
/*            Driver[] innerDriverList = new Driver[5];
            innerDriverList[0] = driver;*/

//Entry<Car, Driver> entry15 = new Entry<>(car1, new Driver("Tim"));

//hashMap[bucketNumber1] = new Entry<>(car1, driver1);