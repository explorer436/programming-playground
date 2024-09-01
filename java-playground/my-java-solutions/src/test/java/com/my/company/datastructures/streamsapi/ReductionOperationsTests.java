package com.my.company.datastructures.streamsapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReductionOperationsTests {
    private ReductionOperations reductionOperations = new ReductionOperations();
    private int[] integerArray = new int[]{1, 2, 3, 4, 5};

    @Test
    public void test_collectAndSummingDouble() {
        Integer actual = reductionOperations.returnSumOfAgesOfMales_Reduce(TestsHelper.getPeople());

        assertEquals(120, actual);
    }

    @Test
    public void test_getSumOfAllElementsOfArray() {
        int actual = reductionOperations.getSumOfAllElementsOfArray(integerArray);

        assertEquals(15, actual);
    }

    @Test
    public void test_getProductOfAllElementsOfArray() {
        int actual = reductionOperations.getProductOfAllElementsOfArray(integerArray);

        assertEquals(120, actual);
    }
}
