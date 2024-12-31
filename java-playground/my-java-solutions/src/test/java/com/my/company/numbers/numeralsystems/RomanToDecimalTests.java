package com.my.company.numbers.numeralsystems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToDecimalTests {
    RomanToDecimal romanToDecimal = new RomanToDecimal();

    @Test
    public void test_swapUsingBitwiseManipulation_01() throws Exception {
        assertAll(
                () -> assertEquals(1, romanToDecimal.romanToDecimal("I")),
                () -> assertEquals(3, romanToDecimal.romanToDecimal("III")),
                () -> assertEquals(8, romanToDecimal.romanToDecimal("VIII")),
                () -> assertEquals(9, romanToDecimal.romanToDecimal("IX")),
                () -> assertEquals(13, romanToDecimal.romanToDecimal("XIII")),
                () -> assertEquals(29, romanToDecimal.romanToDecimal("XXIX")),
                () -> assertEquals(31, romanToDecimal.romanToDecimal("XXXI")),
                () -> assertEquals(43, romanToDecimal.romanToDecimal("XLIII")),
                () -> assertEquals(58, romanToDecimal.romanToDecimal("LVIII")),
                () -> assertEquals(83, romanToDecimal.romanToDecimal("LXXXIII")),
                () -> assertEquals(94, romanToDecimal.romanToDecimal("XCIV")),
                () -> assertEquals(1001, romanToDecimal.romanToDecimal("MI")),
                () -> assertEquals(1794, romanToDecimal.romanToDecimal("MDCCXCIV")),
                () -> assertEquals(1994, romanToDecimal.romanToDecimal("MCMXCIV")),
                () -> assertEquals(2020, romanToDecimal.romanToDecimal("MMXX")),
                () -> assertEquals(3999, romanToDecimal.romanToDecimal("MMMCMXCIX"))
        );
    }
}
