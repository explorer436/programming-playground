package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfAllOddSquaresSmallerThanNTest {

    SumOfAllOddSquaresSmallerThanN sum = new SumOfAllOddSquaresSmallerThanN();

    @Test
    void getSumOfAllOddSquaresSmallerThanN() {
        assertEquals(166666665000d, sum.getSumOfAllOddSquaresSmallerThanN(10000));
    }
}