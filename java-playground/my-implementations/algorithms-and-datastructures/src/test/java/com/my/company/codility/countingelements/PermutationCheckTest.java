package com.my.company.codility.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationCheckTest {

    PermutationCheck  permutationCheck = new PermutationCheck();

    @Test
    void test_solution() {
        assertAll(
                () -> assertEquals(1, permutationCheck.solution(new int[]{4, 1, 3, 2})),
                () -> assertEquals(0, permutationCheck.solution(new int[]{4, 1, 3})),
                () -> assertEquals(1, permutationCheck.solution(new int[]{1})),
                () -> assertEquals(0, permutationCheck.solution(new int[]{2})),
                () -> assertEquals(0, permutationCheck.solution(new int[]{}))
        );
    }
}