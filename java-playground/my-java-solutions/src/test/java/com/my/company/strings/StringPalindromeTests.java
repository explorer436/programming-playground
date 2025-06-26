package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringPalindromeTests {

    StringPalindrome stringPalindrome = new StringPalindrome();

    @Test
    public void test_isPalindrome_caseSensitive_01() throws Exception {
        assertFalse(stringPalindrome.isPalindrome_caseSensitive("Deleveled"));
        assertFalse(stringPalindrome.isPalindrome_caseSensitive("Dele eled"));
    }

    @Test
    public void test_isPalindrome_caseInsensitive_doNotIgnorePunctuation() throws Exception {
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_doNotIgnorePunctuation("Deleveled"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_doNotIgnorePunctuation("Dele eled"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_doNotIgnorePunctuation("Dele ele eled"));
        assertFalse(stringPalindrome.isPalindrome_caseInsensitive_doNotIgnorePunctuation("I did, did I?"));
    }

    @Test
    public void test_isPalindrome_caseInsensitive_ignorePunctuation() throws Exception {
        assertFalse(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("hello"));
        assertFalse(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("Was it a car or a cat I saw?"));

        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("I did, did I?"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("Deleveled"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("Dele eled"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("Dele ele eled"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("Don't nod"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("I did, did I?"));
        assertTrue(stringPalindrome.isPalindrome_caseInsensitive_ignorePunctuation("abccba"));
    }

    @Test
    public void test_isPalindrome_usingStack_01() throws Exception {
        assertTrue(stringPalindrome.isPalindrome_usingStack("Deleveled"));
        assertTrue(stringPalindrome.isPalindrome_usingStack("Don't nod"));
        assertFalse(stringPalindrome.isPalindrome_usingStack("hello"));
        assertTrue(stringPalindrome.isPalindrome_usingStack("I did, did I?"));
        assertTrue(stringPalindrome.isPalindrome_usingStack("Was it a car or a cat I saw?"));
        assertTrue(stringPalindrome.isPalindrome_usingStack("abccba"));
    }

    @Test
    public void test_isPalindrome_usingStackAndQueue_01() throws Exception {
        assertTrue(stringPalindrome.isPalindrome_usingStackAndQueue("Don't nod"));
        assertFalse(stringPalindrome.isPalindrome_usingStackAndQueue("hello"));
        assertTrue(stringPalindrome.isPalindrome_usingStackAndQueue("I did, did I?"));
        assertTrue(stringPalindrome.isPalindrome_usingStackAndQueue("Was it a car or a cat I saw?"));
        assertTrue(stringPalindrome.isPalindrome_usingStackAndQueue("abccba"));
    }

}
