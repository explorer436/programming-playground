package com.my.company.numbers.numeralsystems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecimalToRomanTests {
    DecimalToRoman decimalToRoman = new DecimalToRoman();

    @Test
    public void test_swapUsingBitwiseManipulation_01() throws Exception {
        assertAll(
                () -> assertEquals("I", decimalToRoman.intToRoman(1)),
                () -> assertEquals("III", decimalToRoman.intToRoman(3)),
                () -> assertEquals("VIII", decimalToRoman.intToRoman(8)),
                () -> assertEquals("IX", decimalToRoman.intToRoman(9)),
                () -> assertEquals("XIII", decimalToRoman.intToRoman(13)),
                () -> assertEquals("XXXI", decimalToRoman.intToRoman(31)),
                () -> assertEquals("XLIII", decimalToRoman.intToRoman(43)),
                () -> assertEquals("LVIII", decimalToRoman.intToRoman(58)),
                () -> assertEquals("LXXXIII", decimalToRoman.intToRoman(83)),
                () -> assertEquals("XCIV", decimalToRoman.intToRoman(94)),
                () -> assertEquals("MI", decimalToRoman.intToRoman(1001)),
                () -> assertEquals("MDCCXCIV", decimalToRoman.intToRoman(1794)),
                () -> assertEquals("MCMXCIV", decimalToRoman.intToRoman(1994)),
                () -> assertEquals("MMXX", decimalToRoman.intToRoman(2020)),
                () -> assertEquals("MMMCMXCIX", decimalToRoman.intToRoman(3999))
        );
    }
}
