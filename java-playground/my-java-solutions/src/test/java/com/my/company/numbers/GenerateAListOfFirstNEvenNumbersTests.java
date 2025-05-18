package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateAListOfFirstNEvenNumbersTests {

    GenerateAListOfFirstNEvenNumbers generateAListOfFirstNEvenNumbers = new GenerateAListOfFirstNEvenNumbers();

    @Test
    public void test_01() {
        List<Integer> actual = generateAListOfFirstNEvenNumbers.generateListOfFirstNEvenNumbers(6);
        List<Integer> expected = List.of(0, 2, 4, 6, 8, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void test_02() {
        List<Integer> actual = generateAListOfFirstNEvenNumbers.generateListOfNEvenNumbersFromAGivenNumber(10, 6);
        List<Integer> expected = List.of(6, 8, 10, 12, 14, 16, 18, 20, 22, 24);
        assertEquals(expected, actual);
    }

}
