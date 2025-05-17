package com.my.company.abstractdatatypes.stack;

public class FullyParenthesizedArithmeticExpressionEvaluation {

  /**
   * This Stack client uses two stacks to evaluate arithmetic expressions, illustrating an essential
   * computational process: interpreting a string as a program and executing that program to compute
   * the desired result. With generics, we can use the code in a single Stack implementation to
   * implement one stack of String values and another stack of Double values. For simplicity, this
   * code assumes that the expression is fully parenthesized, with numbers and characters separated
   * by whitespace.
   *
   * <p>% java Evaluate ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 101.0
   *
   * <p>% java Evaluate ( ( 1 + sqrt ( 5.0 ) ) / 2.0 ) 1.618033988749895
   */
  public static void main(String[] args) throws Exception {
    int result;

    result = evaluateExpression("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
    if (result != 101) {
      throw new Exception("wrong answer - expected " + 101 + " but received " + result);
    }

    result = evaluateExpression("( 1 + ( 2 + 3 ) )");
    if (result != 6) {
      throw new Exception("wrong answer - expected " + 6 + " but received " + result);
    }

    /*
     * result = evaluateExpression("( 1 + ( 12 + 3 ) )");
     * if (result != 16)
     * {
     * throw new Exception("wrong answer - expected " + 16 + " but received " +
     * result);
     * }
     */

    // This is not going to work for partially paranthesized expressions
    /*
     * result = evaluateExpression("5 * ( 6 + 2 ) - 12 / 4");
     * if (result != 37)
     * {
     * throw new Exception("wrong answer - expected " + 37 + " but received " +
     * result);
     * }
     */

    System.out.println("done");
  }

  /**
   * FIXME This is not working with two digit numbers. This was probably written to read input using
   * Scanner - which takes care of reading numbers with more than one digits.
   */
  public static int evaluateExpression(String str) {
    StackImplementationUsingLinkedList<Character> operators =
        new StackImplementationUsingLinkedList<Character>();
    StackImplementationUsingLinkedList<Integer> values =
        new StackImplementationUsingLinkedList<Integer>();

    char[] charArray = str.toCharArray();

    for (char ch : charArray) {
      if ('(' == ch || ' ' == ch) {
        // ignore
        continue;
      } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
        operators.push(ch);
      } else if (')' == ch) {
        Integer op2 = values.pop();
        Integer op1 = values.pop();
        char operator = operators.pop();

        int result = 0;
        if ('+' == operator) {
          result = op1 + op2;
        } else if ('-' == operator) {
          result = op1 - op2;
        } else if ('*' == operator) {
          result = op1 * op2;
        } else if ('/' == operator) {
          result = op1 / op2;
        }

        values.push(result);
      } else {
        // REMEMBER : converting char to Integer. Integer.parseInt() is not going to
        // work.
        values.push(Character.getNumericValue(ch));
      }
    }

    return values.pop();
  }
}
