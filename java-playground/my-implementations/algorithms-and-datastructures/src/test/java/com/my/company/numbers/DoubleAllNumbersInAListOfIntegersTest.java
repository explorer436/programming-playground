package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoubleAllNumbersInAListOfIntegersTest {

    DoubleAllNumbersInAListOfIntegers doubleAllNumbersInAListOfIntegers = new DoubleAllNumbersInAListOfIntegers();

    @Test
    void doubleAllNumbersInAList() {
        assertEquals(List.of(2, 4, 6), doubleAllNumbersInAListOfIntegers.doubleAllNumbersInAList(List.of(1, 2, 3)));
    }
}