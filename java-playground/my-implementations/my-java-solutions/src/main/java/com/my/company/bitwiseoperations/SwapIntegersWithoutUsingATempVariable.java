package com.my.company.bitwiseoperations;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class SwapIntegersWithoutUsingATempVariable {

  public static ImmutablePair swapUsingAdditionAndSubtraction(ImmutablePair pair) {
    int a = (int) pair.left;
    int b = (int) pair.right;

    a = a + b;
    b = a - b; // actually (a + b) - (b) -> assign this value to b.
    a = a - b; // which is, (a + b) -((a + b) - (b)) = (a + b) - a = b -> assign this value to a.

    return new ImmutablePair(a, b);
  }

  // See bitwise operations in programming-notes
  public static ImmutablePair swapUsingBitwiseManipulation(ImmutablePair pair) {
    int a = (int) pair.left;
    int b = (int) pair.right;

    a = a ^ b;
    b = a ^ b; // actually (a ^ b) ^ b, which would give us a -> assign this value to b.
    a = a ^ b; // which is, (a ^ b) -((a ^ b) ^ b) = (a ^ b) ^ a = b -> assign this value to a.

    return new ImmutablePair(a, b);
  }
}
