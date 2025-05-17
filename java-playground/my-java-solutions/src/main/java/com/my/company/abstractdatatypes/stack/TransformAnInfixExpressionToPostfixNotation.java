package com.my.company.abstractdatatypes.stack;

import java.util.Stack;

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
