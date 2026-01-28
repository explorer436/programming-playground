package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerPalindromeTest {

    IntegerPalindrome integerPalindrome = new IntegerPalindrome();

    @Test
    void isPalindrome() {
        assertAll(
                () -> assertEquals(true, integerPalindrome.isPalindrome(121)),
                () -> assertEquals(false, integerPalindrome.isPalindrome(-121)),
                () -> assertEquals(false, integerPalindrome.isPalindrome(10))
        );
    }

    @Test
    void isPalindrome_UsingStringConversion() {
        assertAll(
                () -> assertEquals(true, integerPalindrome.isPalindrome_UsingStringConversion(121)),
                () -> assertEquals(false, integerPalindrome.isPalindrome_UsingStringConversion(-121)),
                () -> assertEquals(false, integerPalindrome.isPalindrome_UsingStringConversion(10))
        );
    }

    @Test
    void reverseStringUsingByteArray() {
    }
}