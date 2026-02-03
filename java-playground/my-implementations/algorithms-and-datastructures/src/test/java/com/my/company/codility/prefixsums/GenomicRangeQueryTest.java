package com.my.company.codility.prefixsums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenomicRangeQueryTest {

    GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

    @Test
    void solution() {
        assertTrue(Arrays.equals(new int[] {2, 4, 1}, genomicRangeQuery.solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6})));
    }
}