package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    Factorial  factorial = new Factorial();

    @Test
    void test_factorial_recursive() {

        assertAll(
                () -> assertEquals(24, factorial.factorial_recursive(4)),
                () -> assertEquals(0, factorial.factorial_recursive(-1)),
                () -> assertEquals(1, factorial.factorial_recursive(0)),
                () -> assertEquals(1, factorial.factorial_recursive(1)),
                () -> assertEquals(3628800, factorial.factorial_recursive(10))
        );

    }

    @Test
    void test_factorial_iteration() {

        assertAll(
                () -> assertEquals(24, factorial.factorial_iteration(4)),
                () -> assertEquals(0, factorial.factorial_iteration(-1)),
                () -> assertEquals(1, factorial.factorial_iteration(0)),
                () -> assertEquals(1, factorial.factorial_iteration(1)),
                () -> assertEquals(3628800, factorial.factorial_iteration(10))
        );
    }
}