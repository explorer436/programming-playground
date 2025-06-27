package com.my.company.abstractdatatypes.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluatePostfixExpressionsTests {

    EvaluatePostfixExpressions classUnderTest = new EvaluatePostfixExpressions();

    @Test
    public void testEvaluatePostfixExpressions() {
        assertEquals(37, classUnderTest.evaluatePostfixExpression("5 6 2 + * 12 4 / -"));
    }
}
