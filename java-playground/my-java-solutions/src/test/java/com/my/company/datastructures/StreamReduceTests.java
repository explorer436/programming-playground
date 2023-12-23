package com.my.company.datastructures;

import com.my.company.datastructures.streamsapi.StreamReduce;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamReduceTests {
    private StreamReduce streamReduce = new StreamReduce();
    private int[] integerArray = new int[]{1, 2, 3, 4, 5};

    @Test
    public void test_collectAndSummingDouble() {
        Integer actual = streamReduce.returnSumOfAgesOfMales_Reduce(TestsHelper.getPeople());

        assertEquals(120, actual);
    }

    @Test
    public void test_getSumOfAllElementsOfArray() {
        int actual = streamReduce.getSumOfAllElementsOfArray(integerArray);

        assertEquals(15, actual);
    }

    @Test
    public void test_getProductOfAllElementsOfArray() {
        int actual = streamReduce.getProductOfAllElementsOfArray(integerArray);

        assertEquals(120, actual);
    }
}
