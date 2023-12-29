package spring.boot.mongo.demo.functionalinterface;

import java.util.function.IntToDoubleFunction;

public class _Consumer {

    public static void main(String[] args) {
       // IntToDoubleFunction
        IntToDoubleFunction customOperation = (value) -> Math.sin(value * Math.PI / 180);

        // Test the function
        int angleInDegrees = 90;
        System.out.println("Sine of " + angleInDegrees + " degrees: " + customOperation.applyAsDouble(angleInDegrees));

    }
}
