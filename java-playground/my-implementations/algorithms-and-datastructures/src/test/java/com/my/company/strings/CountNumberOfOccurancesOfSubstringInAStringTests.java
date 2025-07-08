package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNumberOfOccurancesOfSubstringInAStringTests {

    CountNumberOfOccurancesOfSubstringInAString countNumberOfOccurancesOfSubstringInAString = new CountNumberOfOccurancesOfSubstringInAString();

    @Test
    public void test_countNumberOfOccurancesOfSubstringInAString_01() throws Exception {
        int actual = countNumberOfOccurancesOfSubstringInAString.countNumberOfOccurancesOfSubstringInAString("not", "This is not good.");
        assertEquals(1, actual);
    }

    @Test
    public void test_countNumberOfOccurancesOfSubstringInAString_02() throws Exception {
        int actual = countNumberOfOccurancesOfSubstringInAString.countNumberOfOccurancesOfSubstringInAString("br", "brucebruce");
        assertEquals(2, actual);
    }

}
