package com.my.company.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.Random;

public class TakeNFromInfiniteSupplierUsingForLoop {

    public static <T> List<T> takeN(int n, Supplier<T> infiniteSource) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements (n) cannot be negative.");
        }
        if (n == 0) {
            return List.of(); // or Collections.emptyList() for pre-Java 9
        }

        List<T> result = new ArrayList<>(n); // Pre-allocate for efficiency
        for (int i = 0; i < n; i++) {
            result.add(infiniteSource.get());
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> first10Naturals = takeN(10, naturalNumberSupplier());
        System.out.println("First 10 natural numbers: " + first10Naturals); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("Taking 0 elements: " + takeN(0, naturalNumberSupplier())); // []


        List<Integer> first5Randoms = takeN(5, randomNumberSupplier());
        System.out.println("First 5 random numbers: " + first5Randoms);

        List<String> threeHellos = takeN(3, constantStringSupplier());
        System.out.println("Three Hellos: " + threeHellos); // [Hello, Hello, Hello]

    }

    private static Supplier<String> constantStringSupplier() {
        // Infinite sequence of a constant value
        return () -> "Hello";
    }

    private static Supplier<Integer> randomNumberSupplier() {
        Random random = new Random();
        // Infinite sequence of Random numbers between 0 and 99
        return () -> random.nextInt(100);
    }

    public static Supplier<Integer> naturalNumberSupplier() {
        // Infinite sequence of natural numbers (0, 1, 2, ...)
        return new Supplier<>() {
            private int current = 0;
            @Override
            public Integer get() {
                return current++;
            }
        };
    }
}