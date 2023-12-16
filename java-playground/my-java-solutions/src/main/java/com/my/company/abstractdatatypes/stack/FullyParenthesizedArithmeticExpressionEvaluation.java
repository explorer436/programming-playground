package com.my.company.datastructures.stack;

/**
 * Reference : Algorithhms by Robert Sedgewick, Kevin Wayne
 *
 * <p>Arithmetic expression evaluation:
 *
 * <p>As another example of a stack client, we consider a classic example that also demonstrates the
 * utility of generics. Some of the programs that we considered involved computing the value of
 * arithmetic expressions like this one: ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 *
 * <p>If you multiply 4 by 5 , add 3 to 2 , multiply the result, and then add 1 , you get the value
 * 101. But how does the Java system do this calculation? Without going into the details of how the
 * Java system is built, we can address the essential ideas by writing a Java program that can take
 * a string as input (the expression) and produce the number represented by the expression as
 * output. For simplicity, we begin with the following explicit recursive definition: an arithmetic
 * expression is either a number, or a left parenthesis followed by an arithmetic expression
 * followed by an operator followed by another arithmetic ex- pression followed by a right
 * parenthesis. For simplicity, this definition is for fully paren- thesized arithmetic expressions,
 * which specify precisely which operators apply to which operands—you are a bit more familiar with
 * expressions such as 1 + 2 * 3 , where we often rely on precedence rules instead of parentheses.
 * The same basic mechanisms that we consider can handle precedence rules, but we avoid that
 * complication. For speci- ficity, we support the familiar binary operators * , + , - , and / , as
 * well as a square-root operator sqrt that takes just one argument. We could easily allow more
 * operators and more kinds of operators to embrace a large class of familiar mathematical
 * expressions, involving trigonometric, exponential, and logarithmic functions. Our focus is on un-
 * derstanding how to interpret the string of parentheses, operators, and numbers to en- able
 * performing in the proper order the low-level arithmetic operations that are avail- able on any
 * computer. Precisely how can we convert an arithmetic expression—a string of characters—to the
 * value that it represents? A remarkably simple algorithm that was developed by E. W. Dijkstra in
 * the 1960s uses two stacks (one for operands and one for operators) to do this job. An expression
 * consists of parentheses, operators, and oper- ands (numbers). Proceeding from left to right and
 * taking these entities one at a time, we manipulate the stacks according to four possible cases,
 * as follows:
 *
 * <p>■ Push operands onto the operand stack. ■ Push operators onto the operator stack. ■ Ignore
 * left parentheses. ■ On encountering a right parenthesis, pop an operator, pop the requisite
 * number of operands, and push onto the operand stack the result of applying that opera- tor to
 * those operands.
 *
 * <p>After the final right parenthesis has been processed, there is one value on the stack, which
 * is the value of the expression. This method may seem mysterious at first, but it is easy to
 * convince yourself that it computes the proper value: any time the algorithm encounters a
 * subexpression consisting of two operands separated by an operator, all surrounded by parentheses,
 * it leaves the result of performing that operation on those operands on the operand stack. The
 * result is the same as if that value had appeared in the input instead of the subexpression, so we
 * can think of replacing the subexpression by the value to get an expression that would yield the
 * same result. We can apply this argument again and again until we get a single value. For example,
 * the algorithm com- putes the same value for all of these expressions: ( 1 + ( (2 + 3 ) * ( 4 * 5
 * ) ) ) ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) ( 1 + 100 ) 101
 *
 * <p>FullyParenthesizedArithmeticExpressionEvaluation.java is an implementation of this algorithm.
 * This code is a simple example of an interpreter: a program that interprets the computation
 * specified by a given string and performs the computation to arrive at the result.
 */
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
