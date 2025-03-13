package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTests {
    ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    public void test_01() {
        assertAll(
                () -> assertEquals(321, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(123)),
                () -> assertEquals(-123, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(-321)),
                () -> assertEquals(21, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(120)),
                // input is 2147483647
                () -> assertEquals(0, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(Integer.MAX_VALUE)),
                () -> assertEquals(0, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(Integer.MIN_VALUE)),

                () -> assertEquals(534236469, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(964632435)),

                () -> assertEquals(0, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(Integer.MAX_VALUE + 1)),

                () -> assertEquals(0, reverseInteger.reverseWithoutConvertingTheIntegerIntoString(2147483646))
        );

    }
}
