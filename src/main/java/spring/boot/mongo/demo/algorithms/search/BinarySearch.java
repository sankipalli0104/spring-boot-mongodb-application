package spring.boot.mongo.demo.algorithms.search;


class BinarySearch {

    // Returns index of x if it is present in arr[].
    static int binarySearch(int arr[], int numberToFind)
    {
        int start = 0, end = arr.length - 1;
         while(start <= end ){
             //find mid index
             int midIndex = start + (end - start)/2;

             if(arr[midIndex] == numberToFind){
                 return midIndex;
             }
             if(arr[midIndex] < numberToFind){
                 start = midIndex+1;
             } else {
                 end = midIndex-1;
             }
        }

        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = new int[10000];
        for(int t= 0; t < 10000; t++){
            arr[t] = t;
        }
        int x = 666;
        int result = BinarySearch.binarySearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
    }

    public static int linearSearch(int[] arr, int x) {
        for (int index = 0; index < arr.length; index++)
            if(arr[index] == x){
                return index;
            }
        return -1;
    }
}
