package spring.boot.mongo.demo.functionalinterface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _Supplier {

    public static void main(String[] args) {
        // Create a Supplier to generate a sequence of numbers
        Supplier<Stream<Integer>> numberSupplier;
        numberSupplier = () -> Stream.iterate(1, n -> n + 1);

                generateNumbers(numberSupplier, 10).stream().forEach(System.out::println);

    }

    // Use the Supplier to generate a stream of specified size
    public static List<Integer> generateNumbers(Supplier<Stream<Integer>> numberSupplier, int size) {
        return numberSupplier.get()
                .limit(size)
                .collect(Collectors.toList());
    }
}
