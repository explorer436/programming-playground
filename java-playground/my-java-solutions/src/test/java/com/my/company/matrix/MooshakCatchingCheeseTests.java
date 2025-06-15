package com.my.company.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MooshakCatchingCheeseTests {

    public final MooshakCatchingCheese classUnderTest = new MooshakCatchingCheese();

    @Test
    public void test_countOfIntegersForWhichChainLengthIsGreaterThan15() {
        assertEquals(1, classUnderTest.isPath(new int[][] {
                {1, 1, 1},
                {9, 1, 1},
                {0, 1, 0}
        }));

        assertEquals(0, classUnderTest.isPath(new int[][] {
                {0, 0, 0},
                {9, 1, 1},
                {0, 1, 1}
        }));

        assertEquals(0, classUnderTest.isPath(new int[][] {
                {1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 9, 0, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        }));

        assertEquals(1, classUnderTest.isPath(new int[][] {
                {1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 9, 0, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        }));

        assertEquals(0, classUnderTest.isPath(new int[][] {
                {1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 9, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        }));


    }

}
