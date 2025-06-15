package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberUnderNDivisibleByAGivenNumberTests {
    
    public LargestNumberUnderNDivisibleByAGivenNumber largestNumberUnderNDivisibleByAGivenNumber = new LargestNumberUnderNDivisibleByAGivenNumber();

    @Test
    public void test_countOfIntegersForWhichChainLengthIsGreaterThan15() {
        assertEquals(99554, largestNumberUnderNDivisibleByAGivenNumber.getLargestNumberUnderNDivisibleByD(100000, 3829));
        assertEquals(99, largestNumberUnderNDivisibleByAGivenNumber.getLargestNumberUnderNDivisibleByD(100, 9));
        assertEquals(96, largestNumberUnderNDivisibleByAGivenNumber.getLargestNumberUnderNDivisibleByD(100, 8));
    }
    
}
