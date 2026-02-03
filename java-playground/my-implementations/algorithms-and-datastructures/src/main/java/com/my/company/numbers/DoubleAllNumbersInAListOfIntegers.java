package com.my.company.numbers;

import java.util.List;

public class DoubleAllNumbersInAListOfIntegers {

    public List<Integer> doubleAllNumbersInAList(List<Integer> numbers) {
        return numbers.stream().map(x -> x * 2).toList();
    }
}
