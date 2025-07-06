package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedParanthesisTests {

    BalancedParanthesis balancedParanthesis = new BalancedParanthesis();

    @Test
    public void test_balancedParanthesis_01() throws Exception {
        assertFalse(balancedParanthesis.isBalanced(""));
        assertFalse(balancedParanthesis.isBalanced("{}[](){"));
        assertTrue(balancedParanthesis.isBalanced("{}[]()"));
        assertFalse(balancedParanthesis.isBalanced("{)"));
        assertFalse(balancedParanthesis.isBalanced("([)}"));
        assertTrue(balancedParanthesis.isBalanced("{[()]}"));
        assertFalse(balancedParanthesis.isBalanced("{[(])}"));
        assertTrue(balancedParanthesis.isBalanced("{{[[(())]]}}"));
        assertTrue(balancedParanthesis.isBalanced("[()]{}{[()()]()}"));
        assertFalse(balancedParanthesis.isBalanced("[(])"));
    }

    @Test
    public void test_checkIfBracketsAreAdjacentBalanced_01() throws Exception {
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced(""));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("{}[](){"));
        assertTrue(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("{}[]()"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("{)"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("([)}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("{[()]}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("{[(])}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("{{[[(())]]}}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("[()]{}{[()()]()}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreAdjacentBalanced("[(])"));
    }

    @Test
    public void test_checkIfBracketsIsAnExpression_01() throws Exception {
        assertFalse(balancedParanthesis.checkIfBracketsIsAnExpression(""));
        assertFalse(balancedParanthesis.checkIfBracketsIsAnExpression("{}[](){"));
        assertTrue(balancedParanthesis.checkIfBracketsIsAnExpression("{}[]()"));
        assertFalse(balancedParanthesis.checkIfBracketsIsAnExpression("{)"));
        assertFalse(balancedParanthesis.checkIfBracketsIsAnExpression("([)}"));
        assertTrue(balancedParanthesis.checkIfBracketsIsAnExpression("{[()]}"));
        assertFalse(balancedParanthesis.checkIfBracketsIsAnExpression("{[(])}"));
        assertTrue(balancedParanthesis.checkIfBracketsIsAnExpression("{{[[(())]]}}"));
        assertTrue(balancedParanthesis.checkIfBracketsIsAnExpression("[()]{}{[()()]()}"));
        assertFalse(balancedParanthesis.checkIfBracketsIsAnExpression("[(])"));
    }

    @Test
    public void test_checkIfBracketsAreBalancedFromBeginningAndEnding_01() throws Exception {
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding(""));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("{}[](){"));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("{}[]()"));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("{)"));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("([)}"));
        assertTrue(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("{[()]}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("{[(])}"));
        assertTrue(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("{{[[(())]]}}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("[()]{}{[()()]()}"));
        assertFalse(balancedParanthesis.checkIfBracketsAreBalancedFromBeginningAndEnding("[(])"));
    }

}
