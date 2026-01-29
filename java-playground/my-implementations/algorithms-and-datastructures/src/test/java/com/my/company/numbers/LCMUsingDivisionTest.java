package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCMUsingDivisionTest {

    LCMUsingDivision lcm = new LCMUsingDivision();

    @Test
    void lcm_MultiplicationIsAddition() {
        assertEquals(36, lcm.lcm_MultiplicationIsAddition(12, 18));
    }
}