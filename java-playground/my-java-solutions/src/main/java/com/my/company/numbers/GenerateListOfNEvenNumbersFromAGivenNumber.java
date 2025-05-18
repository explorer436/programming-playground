package com.my.company.numbers;

import java.util.List;

import static com.my.company.numbers.TakeNFromInfiniteSupplierUsingStreamLimit.takeNIterate;

public class GenerateListOfNEvenNumbersFromAGivenNumber {
    // Notice that see is always included in the list. So we have to be careful about what value we use as seed.
    // See the test cases.
    public List<Integer> generateListOfNEvenNumbersFromAGivenNumber(int n, int seed) {
        // This will just increment the input number by 2. If the input number is odd, this will generate a sequence of odd numbers.
        // return takeNIterate(n, seed, x -> x + 2);

        // Checking for even numbers
        return takeNIterate(n, seed, x -> x % 2 == 0 ? x + 2 : x + 1);
    }
}
