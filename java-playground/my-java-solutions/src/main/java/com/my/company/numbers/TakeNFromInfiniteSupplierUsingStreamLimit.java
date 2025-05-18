package com.my.company.numbers;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeNFromInfiniteSupplierUsingStreamLimit {

    // Using Stream.generate(Supplier)
    public static <T> List<T> takeNGenerate(int n, Supplier<T> infiniteSource) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements (n) cannot be negative.");
        }
        if (n == 0) {
            return List.of();
        }
        return Stream.generate(infiniteSource)
                .limit(n)
                .collect(Collectors.toList());
    }

    // Using Stream.iterate(seed, UnaryOperator)
    // Good for sequences where each element is derived from the previous one
    public static List<Integer> takeNIterate(int n, int seed, java.util.function.UnaryOperator<Integer> f) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements (n) cannot be negative.");
        }
        if (n == 0) {
            return List.of();
        }
        return Stream.iterate(seed, f)
                .limit(n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Supplier<Integer> naturalNumbersSupplier = naturalNumbersSupplier();
        List<Integer> first10Naturals = takeNGenerate(10, naturalNumbersSupplier);
        System.out.println("First 10 natural numbers (generate): " + first10Naturals); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        System.out.println("Taking 0 elements (generate): " + takeNGenerate(0, naturalNumbersSupplier)); // []

        // If we use the same supplier instance, it will continue from where it left off
        System.out.println("Taking 5 elements (generate): " + takeNGenerate(5, naturalNumbersSupplier)); // [11, 12, 13, 14, 15]

        // When we get a new supplier, the new supplier will start from 1 again.
        System.out.println("Taking 5 elements: " + takeNGenerate(5, naturalNumbersSupplier())); // [1, 2, 3, 4, 5]

        // Example 2 (Stream.generate): Infinite sequence of random numbers
        Random random = new Random();
        Supplier<Integer> randomNumbersSupplier = () -> random.nextInt(100);
        List<Integer> first5Randoms = takeNGenerate(5, randomNumbersSupplier);
        System.out.println("First 5 random numbers (generate): " + first5Randoms);

        // Example 3 (Stream.iterate): Infinite sequence of even numbers (0, 2, 4, ...)
        List<Integer> first7Evens = takeNIterate(7, 0, x -> x + 2);
        System.out.println("First 7 even numbers (iterate): " + first7Evens); // [0, 2, 4, 6, 8, 10, 12]

        // Example 4 (Stream.iterate): Powers of 2
        List<Integer> first5PowersOf2 = takeNIterate(5, 1, x -> x * 2);
        System.out.println("First 5 powers of 2 (iterate): " + first5PowersOf2); // [1, 2, 4, 8, 16]

    }

    private static Supplier<Integer> naturalNumbersSupplier() {
        // Example 1 (Stream.generate): Infinite sequence of natural numbers
        return new Supplier<>() {
            private int current = 1;
            @Override
            public Integer get() {
                return current++;
            }
        };
    }
}
