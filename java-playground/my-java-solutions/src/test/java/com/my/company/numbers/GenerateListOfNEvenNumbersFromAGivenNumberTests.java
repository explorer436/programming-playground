package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateListOfNEvenNumbersFromAGivenNumberTests {

    GenerateListOfNEvenNumbersFromAGivenNumber generateListOfNEvenNumbersFromAGivenNumber = new GenerateListOfNEvenNumbersFromAGivenNumber();

    @Test
    public void test_02() {
        List<Integer> actual = generateListOfNEvenNumbersFromAGivenNumber.generateListOfNEvenNumbersFromAGivenNumber(10, 6);
        List<Integer> expected = List.of(6, 8, 10, 12, 14, 16, 18, 20, 22, 24);
        assertEquals(expected, actual);
    }

    // Notice that see is always included in the list. So we have to be careful about what value we use as seed.

    @Test
    public void test_03() {
        List<Integer> actual = generateListOfNEvenNumbersFromAGivenNumber.generateListOfNEvenNumbersFromAGivenNumber(10, 7);
        List<Integer> expected = List.of(7, 8, 10, 12, 14, 16, 18, 20, 22, 24);
        assertEquals(expected, actual);
    }
}
