package com.my.company.abstractdatatypes.stack;

import java.util.Stack;

public class EvaluatePostfixExpressions {

    public int evaluatePostfixExpression(String expression) {

        char[] charArray = expression.toCharArray();

        Stack stack = new Stack();

        for (int i = 0; i < charArray.length; i++) {
            if (' ' == charArray[i]) {
                continue;
            } else if (charArray[i] >= '0' && charArray[i] <= '9') {
                StringBuffer sb = new StringBuffer();

                while (i < charArray.length && charArray[i] >= '0' && charArray[i] <= '9') {
                    sb.append(charArray[i]);
                    i = i + 1;
                }

                stack.push(Integer.parseInt(sb.toString()));
            } else if (charArray[i] == '+'
                    || charArray[i] == '-'
                    || charArray[i] == '*'
                    || charArray[i] == '/') {
                char currentOperator = charArray[i];
                int b = (int) stack.pop();
                int a = (int) stack.pop();

                stack.push(
                        ExpressionEvaluation.applyOp(
                                currentOperator, b, a));
            }
        }

        return (int) stack.pop();
    }
}
