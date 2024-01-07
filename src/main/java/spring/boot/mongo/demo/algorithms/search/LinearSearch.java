package spring.boot.mongo.demo.algorithms.search;

import java.util.Random;

public class LinearSearch {

    public static void main(String args[])
    {
        int arr[] = new int[100];
        Random random = new Random();
        for(int t= 1; t < 100; t++){
            arr[t] = random.nextInt(1000);
        }
        int x = 1;
        int result = BinarySearch.linearSearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
    }
}
