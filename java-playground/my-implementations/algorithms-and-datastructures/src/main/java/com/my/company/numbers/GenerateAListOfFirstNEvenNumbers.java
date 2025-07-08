package com.my.company.numbers;

import java.util.List;

import static com.my.company.numbers.TakeNFromInfiniteSupplierUsingStreamLimit.takeNIterate;

public class GenerateAListOfFirstNEvenNumbers {

    // See TakeNFromInfiniteSupplierUsingStreamLimit.java
    public List<Integer> generateListOfFirstNEvenNumbers(int n) {
        return takeNIterate(n, 0, x -> x + 2);
    }


}
