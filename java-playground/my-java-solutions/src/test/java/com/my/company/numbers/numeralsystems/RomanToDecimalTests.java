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
                () -> assertEquals(5, romanToDecimal.romanToDecimal("V")),
                () -> assertEquals(8, romanToDecimal.romanToDecimal("VIII")),
                () -> assertEquals(9, romanToDecimal.romanToDecimal("IX")),
                () -> assertEquals(10, romanToDecimal.romanToDecimal("X")),
                () -> assertEquals(13, romanToDecimal.romanToDecimal("XIII")),
                () -> assertEquals(14, romanToDecimal.romanToDecimal("XIV")),
                () -> assertEquals(29, romanToDecimal.romanToDecimal("XXIX")),
                () -> assertEquals(31, romanToDecimal.romanToDecimal("XXXI")),
                () -> assertEquals(43, romanToDecimal.romanToDecimal("XLIII")),
                () -> assertEquals(48, romanToDecimal.romanToDecimal("XLVIII")),
                () -> assertEquals(50, romanToDecimal.romanToDecimal("L")),
                () -> assertEquals(58, romanToDecimal.romanToDecimal("LVIII")),
                () -> assertEquals(83, romanToDecimal.romanToDecimal("LXXXIII")),
                () -> assertEquals(94, romanToDecimal.romanToDecimal("XCIV")),
                () -> assertEquals(100, romanToDecimal.romanToDecimal("C")),
                () -> assertEquals(444, romanToDecimal.romanToDecimal("CDXLIV")),
                () -> assertEquals(500, romanToDecimal.romanToDecimal("D")),				
                () -> assertEquals(1000, romanToDecimal.romanToDecimal("M")),
                () -> assertEquals(1001, romanToDecimal.romanToDecimal("MI")),
                () -> assertEquals(1794, romanToDecimal.romanToDecimal("MDCCXCIV")),
                () -> assertEquals(1994, romanToDecimal.romanToDecimal("MCMXCIV")),
                () -> assertEquals(2020, romanToDecimal.romanToDecimal("MMXX")),
                () -> assertEquals(3999, romanToDecimal.romanToDecimal("MMMCMXCIX"))
        );
    }
}
