package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int mapSize = HashMap.DEFAULT_CAPACITY;
        String[] driverNames =
                {"Mike", "Ted", "John", "Martha", "Linda", "Sue", "Bob",
                        "Margo", "Phil", "Mark", "Steve", "Karl", "Belinda",
                        "Mary", "Teresa", "Suzanne", "Tom", "Rose", "Anna",
                        "Tina", "Jessica", "Becky", "Louisa", "Margo", "Nelly",
                        "Tina", "Jessica", "Becky", "Louisa", "Margo", "Nelly"};
        List<Entry> entries = new ArrayList<>(mapSize);
        for (int i = 0; i < mapSize; i++) {
            entries.add(null);
        }
        System.out.println(entries);
        HashMap hashMap1 = new HashMap(entries);
        fillHashMap(mapSize, driverNames, entries, hashMap1);
        System.out.println("==================================");
        System.out.println(hashMap1);
    }

    public static void fillHashMap(int mapSize, String[] driverNames, List<Entry> entries, HashMap hashMap1) {
        int bucketNumber;
        for (int i = 0; i < mapSize + 12; i++) {
            Car car = new Car(i);
            Driver driver = new Driver(driverNames[i]);

            //System.out.println("Car Object: " + car);
            //System.out.println("HashCode: " + car.hashCode());
            bucketNumber = car.hashCode() % mapSize;
            if(bucketNumber <= mapSize) {
                System.out.println("BucketNumber: " + bucketNumber);

                Entry<Car, Driver> entry = new Entry<>(car, driver);

                entries.set(bucketNumber, entry);
                //System.out.print(entries.get(bucketNumber));
                //System.out.println(entry);
                //System.out.println();
                //checkLoading(hashMap1, mapSize);
                if (checkLoading(hashMap1, mapSize) == mapSize * hashMap1.getDEFAULT_LOAD_FACTOR() / 100) {
                    mapSize = mapSize * 2;
                    System.out.println("The load factor is reached.");
                    System.out.println("New map size: " + mapSize);
                    return;
                }
            }
        }
    }

    public static int checkLoading(HashMap hashMap1, int mapSize) {
        int count = 0;
        for (int i = 0; i < mapSize; i++) {
            if(hashMap1.getEntries().get(i) != null) {
                count++;
            }
        }
        System.out.println("The count is : " + count);
        System.out.println();
        return count;
    }
}







//System.out.println("hashMap1: " + hashMap1);
//checkBucketNumber(bucketNumber);
//entries.add(bucketNumber, entry);

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

//innerCarList1.add(car);

//innerDriverList1.add(driver);
//Entry<Car, Driver> entry = new Entry<>(innerCarList1, innerDriverList1);

/*        List<Car> innerCarList1 = new ArrayList<>();
        List<Driver> innerDriverList1 = new ArrayList<>();*/




//HashMap<Car, Driver> hashMap1 = new HashMap<>();

//Entry[] hashMap = new Entry[mapSize];




/*        for (int i = 0; i < mapSize; i++) {
            System.out.println(hashMap1.getKey()+ + " ");
        }*/
//   (hmse.getKey()+"\t"+hmse.getValue()