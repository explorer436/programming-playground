package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollatzSequencesTests {

    public final CollatzSequences collatzSequences = new CollatzSequences();

    @Test
    public void test_getCollatzSequenceLength() {
        assertEquals(10, collatzSequences.getCollatzSequenceLength(13));
        assertEquals(19, collatzSequences.getCollatzSequenceLength(30));
    }

    @Test
    public void test_countOfIntegersForWhichChainLengthIsGreaterThan15() {
        int actual = collatzSequences.countOfIntegersForWhichChainLengthIsGreaterThan15(0, 100);
        assertEquals(66, actual);
    }

    @Test
    public void test_getCollatzSequence() {
        assertEquals(List.of(13, 40, 20, 10, 5, 16, 8, 4, 2, 1), collatzSequences.getCollatzSequence(13));
        assertEquals(List.of(30, 15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1), collatzSequences.getCollatzSequence(30));
    }

}
