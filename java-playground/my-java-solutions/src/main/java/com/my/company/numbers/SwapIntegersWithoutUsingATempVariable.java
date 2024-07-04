package com.my.company.numbers;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class SwapIntegersWithoutUsingATempVariable {

  /**
   * This technique uses addition and subtraction.
   *
   * <p>The integer addition will not overflow if the result of the addition is more than the
   * maximum value of int primitive as defined by Integer.MAX_VALUE or if the result of the
   * subtraction is less than Integer.MIN_VALUE.
   *
   * <p>The code works in Java because overflows are clearly defined. And, this solution will not
   * work in C or C++.
   *
   * <p>The addition of two numbers will overflow. e.g. Consider that the two numbers in the input
   * are Integer.MAX_VALUE and 10. sum after adding the two input values = Integer.MAX_VALUE + 10 =
   * -2147483639 (after integer overflow). But we are also doing subtraction, which will compensate
   * this value. Now, b = (-2147483639 - 10) = Integer.MAX_VALUE (again, after integer overflow)
   * Now, a = (-2147483639 - Integer.MAX_VALUE) will again overflow to give you 10 as output.
   *
   * <p>As we can see, this gets a little confusing to deal with, especially if the numbers get too
   * large and start overflowing. In languages that do not support overflowing like C/C++, this gets
   * even more diffucult and confusing. Another variant of this solution is using bitwise
   * manipulation. See the other method.
   */
  public static ImmutablePair swapUsingAdditionAndSubtraction(ImmutablePair pair) {
    int a = (int) pair.left;
    int b = (int) pair.right;

    a = a + b;
    b = a - b; // actually (a + b) - (b) -> assign this value to b.
    a = a - b; // which is, (a + b) -((a + b) - (b)) = (a + b) - a = b -> assign this value to a.

    return new ImmutablePair(a, b);
  }

  /**
   * REMEMBER : wherever possible, always prefer bit manipulation to other techniques.
   *
   * <p>The beauty of this method is, we do not have to worry about the datatype of the input
   * variables. Or, their limits. We don't have to worry about overflows. This will work in any
   * language, including the ones that do not support overflows.
   *
   * <p>"^" - bitwise exclusive OR - bitwise XOR
   */
  public static ImmutablePair swapUsingBitwiseManipulation(ImmutablePair pair) {
    int a = (int) pair.left;
    int b = (int) pair.right;

    a = a ^ b;
    b = a ^ b; // actually (a ^ b) ^ b, which would give us a -> assign this value to b.
    a = a ^ b; // which is, (a ^ b) -((a ^ b) ^ b) = (a ^ b) ^ a = b -> assign this value to a.

    return new ImmutablePair(a, b);
  }
}
