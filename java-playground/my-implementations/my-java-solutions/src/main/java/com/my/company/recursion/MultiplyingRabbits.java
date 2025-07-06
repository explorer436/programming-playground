package com.my.company.recursion;

public class MultiplyingRabbits {
  public static void main(String[] args) {
    System.out.println(multiplyingRabbits_recursive(6));
    System.out.println(multiplyingRabbits_iterative(6));
  }

  public static int multiplyingRabbits_recursive(int n) {
    if (n <= 2) {
      return 1;
    } else // n > 2, so n - 1 > 0 and n - 2 > 0
    {
      return multiplyingRabbits_recursive(n - 1) + multiplyingRabbits_recursive(n - 2);
    }
  }

  /*
  * Should we actually use this function? Think about the number of recursive calls that rabbit(10) generates. At best,
  the function rabbit is inefficient. Thus, its use is not feasible for large values of n . We will need some techniques for
  generating a more efficient solution from this same recursive relationship.
  */

  /** Iterative solution to the rabbit problem. */
  public static int multiplyingRabbits_iterative(int n) {
    // Initialize base cases:
    int previous = 1;

    // Initially rabbit(1)
    int current = 1;

    // Initially rabbit(2)
    int next = 1;

    // Compute next rabbit values when n >= 3
    for (int i = 3; i <= n; i++) {
      // current is rabbit(i - 1), previous is rabbit(i - 2)
      next = current + previous;

      // rabbit(i)
      previous = current;

      // Get ready for next iteration
      current = next;
    }

    return next;
  }
}
