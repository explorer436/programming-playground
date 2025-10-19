package com.my.company.datastructures.arrays;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class UniqueNumbersInAnArray {

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);

        Collection<Integer> uniqueNumbers = findUniqueNumbers(numbers);
        for (int number : uniqueNumbers) {
            System.out.println(number); // expected 2, 3
        }
    }

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Set<Integer> mySet = null;
        if (null != numbers) {
            mySet = new HashSet<>();

            for (int i : numbers) {
                if (mySet.contains(i)) {
                    mySet.remove(i);
                } else {
                    mySet.add(i);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        return mySet;
    }
}
