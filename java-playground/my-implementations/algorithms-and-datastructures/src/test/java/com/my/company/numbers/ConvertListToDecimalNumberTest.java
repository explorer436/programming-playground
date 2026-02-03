package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertListToDecimalNumberTest {

    ConvertListToDecimalNumber convertListToDecimalNumber = new ConvertListToDecimalNumber();

    @Test
    void test_convertArrayToDecimalMath() {

        assertAll(
                () -> assertEquals(134, convertListToDecimalNumber.convertArrayToDecimalMath(new int[]{1, 3, 4})),
                () -> assertEquals(5, convertListToDecimalNumber.convertArrayToDecimalMath(new int[]{0, 0, 5})),
                () -> assertEquals(90210, convertListToDecimalNumber.convertArrayToDecimalMath(new int[]{9, 0, 2, 1, 0})),
                () -> assertEquals(0, convertListToDecimalNumber.convertArrayToDecimalMath(new int[]{})),
                () -> assertEquals(Integer.MAX_VALUE, convertListToDecimalNumber.convertArrayToDecimalMathLong(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7})),

                // Overflow
                () -> assertEquals(-2147483648, convertListToDecimalNumber.convertArrayToDecimalMath(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8})),

                // No overflow
                () -> assertEquals(2147483648l, convertListToDecimalNumber.convertArrayToDecimalMathLong(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8}))
        );

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Invalid array
            convertListToDecimalNumber.convertArrayToDecimalMath(new int[]{1, 10, 2});
        });

        String expectedMessage = "Array elements must be single non-negative digits (0-9). Found: 10";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}