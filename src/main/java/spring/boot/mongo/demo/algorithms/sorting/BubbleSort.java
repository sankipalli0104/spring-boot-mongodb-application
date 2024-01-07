package spring.boot.mongo.demo.algorithms.sorting;

public class BubbleSort {

    public static void main (String... str){
        int arr[] = {9, 5, 6, 7, 8, 2, 4, 7};
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println();
        System.out.println("TIME: " + (System.currentTimeMillis() - startTime) + " IN MS");

    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i=0; i < n-1; i++){
             for (int j = 0; j < n-i-1; j++ ){
                 if(arr[j] > arr[j+1]){
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
             }
         }
        for (int t: arr) {
            System.out.print("-->"+t);
        }
    }
}
