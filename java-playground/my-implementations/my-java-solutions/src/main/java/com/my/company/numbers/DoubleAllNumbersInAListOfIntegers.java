package com.my.company.numbers;

import java.util.List;

public class DoubleAllNumbersInAListOfIntegers {

    public static List<Integer> doubleAllNumbersInAList(List<Integer> numbers) {

        return numbers.stream().map(x -> x * 2).toList();
    }

    public static void main(String[] args) {
        System.out.println(doubleAllNumbersInAList(List.of(1, 2, 3))); // [2, 4, 6]
    }
}
