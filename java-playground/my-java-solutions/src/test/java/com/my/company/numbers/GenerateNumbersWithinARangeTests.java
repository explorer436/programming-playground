package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateNumbersWithinARangeTests {

    GenerateNumbersWithinARange generateNumbersWithinARange = new GenerateNumbersWithinARange();

    @Test
    public void test_getNumbersInRangeExclusive() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersInRangeExclusive(0, 6);
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void test_getNumbersInRangeInclusive() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersInRangeInclusive(0, 6);
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void test_getNumbersUsingSupplier_wholeNumbers() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersUsingSupplier( 6, TakeNFromInfiniteSupplierUsingForLoop.wholeNumberSupplier());
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void test_getNumbersUsingSupplier_naturalNumbers() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersUsingSupplier( 6, TakeNFromInfiniteSupplierUsingForLoop.naturalNumberSupplier());
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void test_getNumbersUsingIntStreamRange() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersUsingIntStreamRange(0, 6);
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void test_getNumbersUsingIntStreamRangeClosed() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersUsingIntStreamRangeClosed(0, 6);
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void test_getNumbersUsingIntStreamIterate() {
        List<Integer> actual = generateNumbersWithinARange.getNumbersUsingIntStreamIterate(0, 6);
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

}
