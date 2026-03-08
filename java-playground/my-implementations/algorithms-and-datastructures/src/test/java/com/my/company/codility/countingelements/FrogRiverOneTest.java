package com.my.company.codility.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogRiverOneTest {

    FrogRiverOne frogRiverOne = new FrogRiverOne();

    @Test
    void test_solution() {
        assertAll(
                () -> assertEquals(6, frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4})),
                () -> assertEquals(-1, frogRiverOne.solution(5, new int[]{3})),
                () -> assertEquals(-1, frogRiverOne.solution(2, new int[]{3})),
                () -> assertEquals(-1, frogRiverOne.solution(3, new int[]{3})),
                () -> assertEquals(0, frogRiverOne.solution(1, new int[]{1})),
                () -> assertEquals(-1, frogRiverOne.solution(2, new int[]{2,2,2,2,2}))
        );
    }
}