package com.my.company.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyingRabbitsTest {

    MultiplyingRabbits multiplyingRabbits = new MultiplyingRabbits();

    @Test
    void multiplyingRabbits() {
        assertAll(
                () -> assertEquals(8, multiplyingRabbits.multiplyingRabbits_recursive(6)),
                () -> assertEquals(8, multiplyingRabbits.multiplyingRabbits_iterative(6))
        );
    }
}