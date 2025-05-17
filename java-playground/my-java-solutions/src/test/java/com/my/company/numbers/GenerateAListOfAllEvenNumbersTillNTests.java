package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateAListOfAllEvenNumbersTillNTests {
    GenerateAListOfAllEvenNumbersTillN generateAListOfAllEvenNumbersTillN = new GenerateAListOfAllEvenNumbersTillN();

    @Test
    public void test_01() {
        List<Integer> actual = generateAListOfAllEvenNumbersTillN.generateAListOfAllEvenNumbersTillN(6);
        List<Integer> expected = List.of(0,2,4,6);
        assertEquals(expected, actual);
    }
}
