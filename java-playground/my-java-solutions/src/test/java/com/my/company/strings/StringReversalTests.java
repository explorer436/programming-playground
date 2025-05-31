package com.my.company.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringReversalTests {

    StringReversal stringReversal = new StringReversal();

    @Test
    public void test_reverseStringUsingApacheCommonsLibrary_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingApacheCommonsLibrary("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingApacheCommonsLibrary("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingApacheCommonsLibrary("damage"));
        assertEquals("", stringReversal.reverseStringUsingApacheCommonsLibrary(""));
        assertNull(stringReversal.reverseStringUsingApacheCommonsLibrary(null));
    }

    @Test
    public void test_reverseStringUsingRecursion_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingRecursion("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingRecursion("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingRecursion("damage"));
        assertEquals("", stringReversal.reverseStringUsingRecursion(""));
        assertNull(stringReversal.reverseStringUsingRecursion(null));
    }

    @Test
    public void test_reverseStringUsingWhileLoop_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingWhileLoop("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingWhileLoop("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingWhileLoop("damage"));
        assertEquals("", stringReversal.reverseStringUsingWhileLoop(""));
        assertNull(stringReversal.reverseStringUsingWhileLoop(null));
    }

    @Test
    public void test_reverseStringUsingForLoop_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingForLoop("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingForLoop("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingForLoop("damage"));
        assertEquals("", stringReversal.reverseStringUsingForLoop(""));
        assertNull(stringReversal.reverseStringUsingForLoop(null));
    }

    @Test
    public void test_reverseStringUsingByteArray_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingByteArray("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingByteArray("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingByteArray("damage"));
        assertEquals("", stringReversal.reverseStringUsingByteArray(""));
        assertNull(stringReversal.reverseStringUsingByteArray(null));
    }

    @Test
    public void test_reverseStringUsingStringBuilder_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingStringBuilder("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingStringBuilder("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingStringBuilder("damage"));
        assertEquals("", stringReversal.reverseStringUsingStringBuilder(""));
        assertNull(stringReversal.reverseStringUsingStringBuilder(null));
    }

    @Test
    public void test_reverseStringUsingCharArray1_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingCharArray1("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingCharArray1("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingCharArray1("damage"));
        assertEquals("", stringReversal.reverseStringUsingCharArray1(""));
        assertNull(stringReversal.reverseStringUsingCharArray1(null));
    }

    @Test
    public void test_reverseStringUsingCharArray2_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingCharArray2("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingCharArray2("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingCharArray2("damage"));
        assertEquals("", stringReversal.reverseStringUsingCharArray2(""));
        assertNull(stringReversal.reverseStringUsingCharArray2(null));
    }

    @Test
    public void test_reverseStringUsingCollections_01() throws Exception {
        assertEquals("Madam, I'm Adam", stringReversal.reverseStringUsingCollections("madA m'I ,madaM"));
        assertEquals("tac", stringReversal.reverseStringUsingCollections("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingCollections("damage"));
        assertEquals("", stringReversal.reverseStringUsingCollections(""));
        assertNull(stringReversal.reverseStringUsingCollections(null));
    }

}
