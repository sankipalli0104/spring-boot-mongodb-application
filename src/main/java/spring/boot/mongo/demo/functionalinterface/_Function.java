package spring.boot.mongo.demo.functionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        System.out.println("Imperative Approach - increment ="+increment(0));

        System.out.println("Declarative Approach - increamentByone ="+increamentByone.apply(4));

        System.out.println("Imperative Approach - multiplyByTen ="+multiplyByTen(10));

        System.out.println("Imperative Approach - multiplyBy10 ="+multiplyBy10.apply(4));

    }

    //Imperative Approach
    static int increment(int num){
        return num+1;
    }

    static int multiplyByTen(int num){
        return num*10;
    }



    //Declarative approach
    static Function<Integer, Integer> increamentByone = number -> number +1;

    static Function<Integer, Integer> multiplyBy10 = number -> number*10;

}
