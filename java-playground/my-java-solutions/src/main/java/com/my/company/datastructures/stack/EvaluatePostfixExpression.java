package com.my.company.datastructures.stack;

import java.util.Stack;

// http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm

/**
 * Evaluate a postfix expression
 *
 * <p>Suppose P is an arithmetic expression in postfix notation. We will evaluate it using a stack
 * to hold the operands.
 *
 * <p>Start with an empty stack. We scan P from left to right.
 *
 * <p>While (we have not reached the end of P) If an operand is found push it onto the stack End-If
 * If an operator is found Pop the stack and call the value A Pop the stack and call the value B
 * Evaluate B op A using the operator just found. Push the resulting value onto the stack End-If
 * End-While Pop the stack (this is the final value)
 *
 * <p>Notes:
 *
 * <p>At the end, there should be only one element left on the stack.
 *
 * <p>This assumes the postfix expression is valid.
 */
public class EvaluatePostfixExpression {

    public static void main(String[] args) throws Exception {
        int result = evaluatePostfixExpression("5 6 2 + * 12 4 / -");
        if (result != 37) {
            throw new Exception("wrong answer - expected " + "37" + " but received " + result);
        }

        System.out.println("done");
    }

    private static int evaluatePostfixExpression(String expression) {

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

                stack.push(ExpressionEvaluation.applyOp(currentOperator, b, a));
            }
        }

        return (int) stack.pop();
    }
}
