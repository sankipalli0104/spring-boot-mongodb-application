package spring.boot.mongo.demo.scheduler;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        int arr[] = {1, 2,4,6,7,3,4,6,3,5,6,5,6,4,5,3,5};
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(arr).forEach(num -> sum.addAndGet(num));
        System.out.println(sum.get());
    }
}
