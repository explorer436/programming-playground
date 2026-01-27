package com.my.company.codility.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestPositiveNumberMissingFromArrayTest {

    SmallestPositiveNumberMissingFromArray smallestPositiveNumberMissingFromArray = new SmallestPositiveNumberMissingFromArray();

    @Test
    void getFirstMissingPositiveInteger_ImplementedUsingMap() {
        assertAll(
                () -> assertEquals(5, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingMap(new int[]{1, 3, 6, 4, 1, 2})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingMap(new int[]{-1, -3})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingMap(new int[]{3})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingMap(new int[]{2,2,2,2,2})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingMap(new int[]{})),
                () -> assertEquals(4, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingMap(new int[]{1,2,3}))
        );
    }

    @Test
    void getFirstMissingPositiveInteger_ImplementedUsingSet() {
        assertAll(
                () -> assertEquals(5, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingSet(new int[]{1, 3, 6, 4, 1, 2})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingSet(new int[]{-1, -3})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingSet(new int[]{3})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingSet(new int[]{2,2,2,2,2})),
                () -> assertEquals(1, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingSet(new int[]{})),
                () -> assertEquals(4, smallestPositiveNumberMissingFromArray.getFirstMissingPositiveInteger_ImplementedUsingSet(new int[]{1,2,3}))
        );
    }
}