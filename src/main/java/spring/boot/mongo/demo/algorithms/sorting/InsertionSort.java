package spring.boot.mongo.demo.algorithms.sorting;

import java.util.Random;

public class InsertionSort {
    public static void main(String... str) {

        int arr[] = new int[10];
        Random random = new Random();
        for (int t = 0; t < arr.length; t++) {
            arr[t] = random.nextInt(99);
            System.out.print("--> " + arr[t]);
        }

        int[] sortedArray = insertionSort(arr);
        System.out.println();
        for (int i : sortedArray) {
            System.out.print("--> " + i);
        }
    }

    private static int[] insertionSort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int temp = array[index];
            int j = index - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
