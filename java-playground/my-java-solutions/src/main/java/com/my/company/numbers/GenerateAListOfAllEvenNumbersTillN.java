package com.my.company.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateAListOfAllEvenNumbersTillN {

    public List<Integer> generateAListOfAllEvenNumbersTillN(int n) {

        // To generate a range that is exclusive of higher limit
        // List<Integer> l = IntStream.range(0, n).boxed().toList();

        // To generate a range that is inclusive of higher limit
        List<Integer> l = IntStream.rangeClosed(0, n).boxed().toList();

        return l.stream()
                .filter(num -> (num % 2) == 0)
                .collect(Collectors.toList());
    }

}
