package com.my.company.datastructures.stack;

import java.util.Stack;

// http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm

// https://www.cis.upenn.edu/~matuszek/cit594-2002/Assignments/5-expressions.html

// https://en.wikipedia.org/wiki/Shunting-yard_algorithm

/**
 * This is the equivalent of two algorithms put together. 1.
 * TransformAnInfixExpressionToPostfixNotation.java 2. EvaluatePostfixExpression
 */

/**
 * A Java program to evaluate a given expression where tokens are separated by space. Test Cases:
 * "10 + 2 * 6" ---> 22 "100 * 2 + 12" ---> 212 "100 * ( 2 + 12 )" ---> 1400 "100 * ( 2 + 12 ) / 14"
 * ---> 100
 */
public class ExpressionEvaluation {
    public static void main(String[] args) throws Exception {
        int result;

        result = ExpressionEvaluation.evaluate("10 + 2 * 6");
        if (22 != result) {
            throw new Exception("wrong answer - expected " + "22" + " but received " + result);
        }

        result = ExpressionEvaluation.evaluate("100 * 2 + 12");
        if (212 != result) {
            throw new Exception("wrong answer - expected " + "212" + " but received " + result);
        }

        result = ExpressionEvaluation.evaluate("100 * ( 2 + 12 )");
        if (1400 != result) {
            throw new Exception("wrong answer - expected " + "1400" + " but received " + result);
        }

        result = ExpressionEvaluation.evaluate("100 * ( 2 + 12 ) / 14");
        if (100 != result) {
            throw new Exception("wrong answer - expected " + "100" + " but received " + result);
        }

        result = ExpressionEvaluation.evaluate("10 * 2 / 4");
        if (5 != result) {
            throw new Exception("wrong answer - expected " + "5" + " but received " + result);
        }

        result = ExpressionEvaluation.evaluate("1 + 4 * 2 / 3");
        if (3 != result) {
            throw new Exception("wrong answer - expected " + "3" + " but received " + result);
        }

    /*
          result = ExpressionEvaluation.evaluate("10 * (2 + 3 - 1) / 4");
          if (10 != result)
    {
    	throw new Exception("wrong answer - expected " + "10" + " but received " + result);
    }
    */

        System.out.println("done");
    }

    public static int evaluate(String expression) {
        char[] expressionCharArray = expression.toCharArray();

        // Stack for numbers: 'numbersStack'
        Stack<Integer> numbersStack = new Stack<>();

        // Stack for Operators: 'operatorsStack'
        Stack<Character> operatorsStack = new Stack<>();

        for (int i = 0; i < expressionCharArray.length; i++) {
            // Current token is a whitespace, skip it
            if (expressionCharArray[i] == ' ') {
                continue;
            }

            // Current token is a number, push it to stack for numbers
            if (expressionCharArray[i] >= '0' && expressionCharArray[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                // There may be more than one digit in number.
                while (i < expressionCharArray.length
                        && expressionCharArray[i] >= '0'
                        && expressionCharArray[i] <= '9') {
                    sbuf.append(expressionCharArray[i++]);
                }

                numbersStack.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'operatorsStack'
            else if (expressionCharArray[i] == '(') {
                operatorsStack.push(expressionCharArray[i]);
            }

            // Closing brace encountered, solve entire brace
            else if (expressionCharArray[i] == ')') {
                while (operatorsStack.peek() != '(') {
                    int b = numbersStack.pop();
                    int a = numbersStack.pop();
                    int resultFromTheBraces = applyOp(operatorsStack.pop(), b, a);
                    numbersStack.push(resultFromTheBraces);
                }

                // pop the corresponding closing brace and ignore it.
                operatorsStack.pop();
            }

            // Current token is an operator.
            else if (expressionCharArray[i] == '+'
                    || expressionCharArray[i] == '-'
                    || expressionCharArray[i] == '*'
                    || expressionCharArray[i] == '/') {
                char currentOperator = expressionCharArray[i];
                // While top of 'operatorsStack' has same or greater precedence to current operator.
                // Apply operator on top of 'operatorsStack' to top two elements in numbersStack stack.
                while (!operatorsStack.empty()
                        && currentOperatorsPrecedenceIsLessThanThoseFromTheStack(
                        currentOperator, operatorsStack.peek())) {
                    numbersStack.push(applyOp(operatorsStack.pop(), numbersStack.pop(), numbersStack.pop()));
                }

                // Push current token to 'operatorsStack'.
                operatorsStack.push(currentOperator);
            }
        }

        // Entire expression has been parsed at this point, apply remaining operatorsStack to remaining
        // numbersStack.
        while (!operatorsStack.empty()) {
            numbersStack.push(applyOp(operatorsStack.pop(), numbersStack.pop(), numbersStack.pop()));
        }

        // Top of 'numbersStack' contains result, return it.
        return numbersStack.pop();
    }

    /**
     * REMEMBER: This is the key for Dijkstra's Shunting-yard algorithm.
     *
     * <p>B Brackets first O Orders (ie Powers and Square Roots, etc.) DM Division and Multiplication
     * AS Addition and Subtraction
     */
    // Returns true if 'operatorAtTheTopOfTheStack' has higher or same precedence as
    // 'currentOperator', otherwise returns false.
    public static boolean currentOperatorsPrecedenceIsLessThanThoseFromTheStack(
            char currentOperator, char operatorAtTheTopOfTheStack) {
        if (operatorAtTheTopOfTheStack == '(' || operatorAtTheTopOfTheStack == ')') {
            return false;
        }

        if ((currentOperator == '*' || currentOperator == '/')
                && (operatorAtTheTopOfTheStack == '+' || operatorAtTheTopOfTheStack == '-')) {
            return false;
        }

        return true;
    }

    // A utility method to apply an operator 'op' on operands 'a' and 'b'.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
}
