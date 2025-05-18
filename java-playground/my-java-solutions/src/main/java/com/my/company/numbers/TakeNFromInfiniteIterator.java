package com.my.company.numbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TakeNFromInfiniteIterator {

    public static <T> List<T> takeN(int n, Iterator<T> infiniteIterator) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements (n) cannot be negative.");
        }
        if (n == 0) {
            return List.of();
        }

        List<T> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            // Assuming the iterator is truly infinite, hasNext() will always be true
            // and next() will always succeed for 'n' calls.
            // If there was a chance it wasn't infinite, you'd add:
            // if (!infiniteIterator.hasNext()) { break; /* or throw exception */ }
            result.add(infiniteIterator.next());
        }
        return result;
    }

    public static void main(String[] args) {
        Iterator<Integer> naturalNumbersIterator = naturalNumberIterator();
        List<Integer> first10Naturals = takeN(10, naturalNumbersIterator);
        System.out.println("First 10 natural numbers (iterator): " + first10Naturals);

        System.out.println("Taking 0 elements (iterator): " + takeN(0, naturalNumberIterator())); // []

        // The same iterator instance will continue from where it left off
        List<Integer> next5Naturals = takeN(5, naturalNumbersIterator);
        System.out.println("Next 5 natural numbers (iterator): " + next5Naturals); // [10, 11, 12, 13, 14]

        // When we get a new iterator, the new iterator will start from 0 again.
        System.out.println("Taking 5 elements (iterator): " + takeN(5, naturalNumberIterator())); // [0, 1, 2, 3, 4]
    }

    private static Iterator<Integer> naturalNumberIterator() {

        return new Iterator<Integer>() {

            private int current = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                // No need to check hasNext() if we assume it's truly infinite
                // and we only call next() n times.

                // Assuming the iterator is truly infinite, hasNext() will always be true
                // and next() will always succeed for 'n' calls.
                // If there was a chance it wasn't infinite, you'd add:
                // if (!naturalNumberIterator.hasNext()) { return current++ }
                return current++;
            }
        };

    }
}