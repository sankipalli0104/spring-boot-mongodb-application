package spring.boot.mongo.demo.algorithms.sorting;

import java.util.Random;

public class SelectionSort {

    public static void main(String... str) {

        int arr[] = new int[10];
        Random random = new Random();
        for (int t = 0; t < arr.length; t++) {
            arr[t] = random.nextInt(100);
        }
        long startTime = System.currentTimeMillis();
        int[] sortedArr = insertionSort(arr);
        System.out.println("TIME: " + (System.currentTimeMillis() - startTime) + " IN MS");
        for (int t : sortedArr) {
            System.out.print(t + "-->");
        }
        System.out.println();

    }

    private static int[] insertionSort(int[] arr) {
        if (arr.length < 1) return arr;
        for (int i = 0; i < arr.length - 1; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length - 1; j++) {
                if (minValue > arr[j + 1]) {
                    minValue = arr[j + 1];
                    minIndex = j + 1;
                }
            }
            int temp = arr[i];
            arr[i] = minValue;
            arr[minIndex] = temp;

        }
        return arr;
    }


}
