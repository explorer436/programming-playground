package com.my.company.abstractdatatypes.stack;

import java.util.Stack;

// http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm

// https://en.wikipedia.org/wiki/Shunting-yard_algorithm

/**
 * We often deal with arithmetic expressions written in what is called infix notation: (Operand1 op
 * Operand2)
 *
 * <p>We have rules to indicate which operations take precedence over others, and we often use
 * parentheses to override those rules.
 *
 * <p>It is also quite possible to write arithmetic expressions using postfix notation: (Operand1
 * Operand2 op)
 *
 * <p>With postfix notation, it is possible to use a stack to find the overall value of an infix
 * expression by first converting it to postfix notation.
 *
 * <p>Example: Suppose we have this infix expression I: 5 * ( 6 + 2 ) - 12 / 4
 *
 * <p>The equivalent postfix expression P is: 5 6 2 + * 12 4 / -
 *
 * <p>This discussion assumes all our operations are binary operations (2 arguments each). Notice
 * that we also sometimes use unary operations such as ++ or -- or the unary + and -.
 *
 * <p>We are not including the possibility of array elements in this discussion. (The subscript can
 * be an expression which would have to be evaluated.)
 *
 * <p>One way to think of an expression is as a list or sequence of items, each of which is a left
 * parenthesis, right parenthesis, argument, or operator. An argument can be a constant or the name
 * of a variable. Presumably it would be necessary at some point to replace each variable with its
 * value.
 *
 * <p>There are two algorithms involved. One converts an infix expression to postfix form, and the
 * other evaluates a postfix expression. Each uses a stack.
 */
public class TransformAnInfixExpressionToPostfixNotation {

  public static void main(String[] args) throws Exception {
    String result = null;

    result = transformInfixToPostfix("5 * ( 6 + 2 ) - 12 / 4");
    if (!result.equals("5 6 2 + * 12 4 / -")) {
      throw new Exception(
          "wrong answer - expected " + "5 6 2 + * 12 4 / -" + " but received " + result);
    }

    System.out.println("done");
  }

  /**
   * Suppose I is an arithmetic expression in infix notation. We will create an equivalent postfix
   * expression P by adding items to on the right of P. The new expression P will not contain any
   * parentheses.
   *
   * <p>We will use a stack in which each item may be a left parenthesis or the symbol for an
   * operation.
   *
   * <p>Start with an empty stack. We scan I from left to right.
   *
   * <p>While (we have not reached the end of I) If (an operand is found) Add it to P End-If If (a
   * left parenthesis is found) Push it onto the stack End-If If (a right parenthesis is found)
   * While (the stack is not empty AND the top item is not a left parenthesis) Pop the stack and add
   * the popped value to P End-While Pop the left parenthesis from the stack and discard it End-If
   * If (an operator is found) If (the stack is empty or if the top element is a left parenthesis)
   * Push the operator onto the stack Else While (the stack is not empty AND the top of the stack is
   * not a left parenthesis AND precedence of the operator <= precedence of the top of the stack)
   * Pop the stack and add the top value to P End-While Push the latest operator onto the stack
   * End-If End-If End-While While (the stack is not empty) Pop the stack and add the popped value
   * to P End-While
   *
   * <p>Notes:
   *
   * <p>At the end, if there is still a left parenthesis at the top of the stack, or if we find a
   * right parenthesis when the stack is empty, then I contained unbalanced parentheses and is in
   * error.
   */
  public static String transformInfixToPostfix(String expression) {
    char[] expressionCharArray = expression.toCharArray();

    // Stack for the postfix expression: 'postfixStack'
    Stack postfixStack = new Stack<>();

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

        postfixStack.push(Integer.parseInt(sbuf.toString()));
      }

      // Current token is an opening brace, push it to 'operatorsStack'
      else if (expressionCharArray[i] == '(') {
        operatorsStack.push(expressionCharArray[i]);
      }

      // Closing brace encountered, solve entire brace
      else if (expressionCharArray[i] == ')') {
        while (operatorsStack.peek() != '(') {
          Character operator = operatorsStack.pop();
          postfixStack.push(operator);
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
        // Apply operator on top of 'operatorsStack' to top two elements in postfixStack stack.
        while (!operatorsStack.empty()
            && ExpressionEvaluation.currentOperatorsPrecedenceIsLessThanThoseFromTheStack(
                currentOperator, operatorsStack.peek())) {
          postfixStack.push(operatorsStack.pop());
        }

        // Push current token to 'operatorsStack'.
        operatorsStack.push(currentOperator);
      }
    }

    // Entire expression has been parsed at this point, apply remaining operatorsStack to remaining
    // postfixStack.
    while (!operatorsStack.empty()) {
      postfixStack.push(operatorsStack.pop());
    }

    return ReverseAGivenStack.reverseUsingTempStack(postfixStack);
  }
}
