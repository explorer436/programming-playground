package com.my.company.datastructures.arrays;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayCyclicRotationTests {

    ArrayCyclicRotation classUnderTest = new ArrayCyclicRotation();

    @Test
    public void test() {

        int[] actual = classUnderTest.solution(new int[]{1, 5, 2, 1, 4, 0}, 2);
        int[] expected = new int[]{4, 0, 1, 5, 2, 1};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.solution(new int[]{1, 5, 2, 1, 4, 0}, 0);
        expected = new int[]{1, 5, 2, 1, 4, 0};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.solution(new int[]{1, 5, 2, 1, 4, 0}, 6);
        expected = new int[]{1, 5, 2, 1, 4, 0};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.solution(new int[]{1, 5, 2, 1, 4, 0}, 10);
        expected = new int[]{2, 1, 4, 0, 1, 5};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.solution(new int[]{}, 2);
        expected = new int[]{};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.solution(new int[]{}, -2);
        expected = new int[]{};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.getQueriedPositionsAfterCyclicArrayRotation(new int[]{1, 2, 3}, 2, new int[]{0, 1, 2});
        expected = new int[]{2, 3, 1};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.getQueriedPositionsAfterCyclicArrayRotation(
                new int[]{1, 5, 2, 1, 4, 0}, 2, new int[]{0, 1, 2});
        expected = new int[]{4, 0, 1};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        actual = classUnderTest.getQueriedPositionsAfterCyclicArrayRotation(
                new int[]{}, 2, new int[]{});
        expected = new int[]{};
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));

        List<Integer> actualList = (List<Integer>) classUnderTest.rotate2(new ArrayList<>(Arrays.asList(1, 5, 2, 1, 4, 0)), 2);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(4, 0, 1, 5, 2, 1));
        assertEquals(expectedList, actualList);

        actualList = (List<Integer>) classUnderTest.rotate2(new ArrayList<>(Arrays.asList(1, 5, 2, 1, 4, 0)), 1);
        expectedList = new ArrayList<>(Arrays.asList(0, 1, 5, 2, 1, 4));
        assertEquals(expectedList, actualList);

        actualList = (List<Integer>) classUnderTest.rotate2(new ArrayList<>(Arrays.asList(1, 5, 2, 1, 4, 0)), 8);
        expectedList = new ArrayList<>(Arrays.asList(4, 0, 1, 5, 2, 1));
        assertEquals(expectedList, actualList);

        actualList = (List<Integer>) classUnderTest.rotate2(new ArrayList<>(Arrays.asList(1, 5, 2, 1, 4, 0)), -1);
        expectedList = new ArrayList<>(Arrays.asList(5, 2, 1, 4, 0, 1));
        assertEquals(expectedList, actualList);

        actualList = (List<Integer>) classUnderTest.rotate2(new ArrayList<>(Arrays.asList(1, 5, 2, 1, 4, 0)), -3);
        expectedList = new ArrayList<>(Arrays.asList(1, 4, 0, 1, 5, 2));
        assertEquals(expectedList, actualList);
    }

}
