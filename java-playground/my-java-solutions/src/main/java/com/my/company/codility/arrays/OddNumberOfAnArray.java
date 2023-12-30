package com.my.company.codility.arrays;

public class OddNumberOfAnArray {
  public static void main(String[] args) {
    System.out.println("starting test class");

    OddNumberOfAnArray classUnderTest = new OddNumberOfAnArray();

    System.out.println(
        "The odd number in the array { 9, 3, 9, 3, 9, 7, 9 } is : "
            + classUnderTest.findOddNumberInTheArray(new int[] {9, 3, 9, 3, 9, 7, 9}));

    System.out.println(
        "The odd number in the array { 1 } is : "
            + classUnderTest.findOddNumberInTheArray(new int[] {1}));

    System.out.println(
        "The odd number in the array { } is : "
            + classUnderTest.findOddNumberInTheArray(new int[] {}));

    System.out.println(
        "Is there an odd number in the array { 9, 3, 9, 3, 9, 7, 9 }) : "
            + classUnderTest.isThereAnOddNumberInTheArray(new int[] {9, 3, 9, 3, 9, 7, 9}));

    System.out.println(
        "Is there an odd number in the array { 1 } : "
            + classUnderTest.isThereAnOddNumberInTheArray(new int[] {1}));

    System.out.println(
        "Is there an odd number in the array { 1, 2, 1, 2 } : "
            + classUnderTest.isThereAnOddNumberInTheArray(new int[] {1, 2, 1, 2}));

    System.out.println(
        "Is there an odd number in the array { } : "
            + classUnderTest.isThereAnOddNumberInTheArray(new int[] {}));
  }

  /**
   * "^" - bitwise exclusive OR - bitwise XOR It tells whether there is an odd number of 1 bits (A
   * XOR B XOR C XOR D XOR E} is true iff an odd number of the variables are true).
   *
   * <p>Bits for 0 - 0000 Bits for 9 - 1001 Bits for 3 - 0011 Bits for 7 - 0111
   *
   * <p>XOR on 0 and { 9, 3, 9, 3, 9, 7, 9 }
   *
   * <p>XOR on 0 and 9 - 0000 1001 ---- 1001
   *
   * <p>XOR on 1001 and 3 - 1001 0011 ---- 1010
   *
   * <p>XOR on 1010 and 9 - 1010 1001 ---- 0011
   *
   * <p>XOR on 0011 and 3 - 0011 0011 ---- 0000
   *
   * <p>XOR on 0000 and 9 - 0000 1001 ---- 1001
   *
   * <p>XOR on 1001 and 7 - 1001 0111 ---- 1110
   *
   * <p>XOR on 0000 and 9 - 1110 1001 ---- 0111 - this evaluates to 7
   */

  /*
   * return the odd number
   */
  public int findOddNumberInTheArray(int[] A) {
    int result = 0;
    for (int x : A) {
      result ^= x;
    }
    return result;
  }

  /*
   * return true or false
   */
  public boolean isThereAnOddNumberInTheArray(int[] A) {
    int xorResult = 0;
    for (int x : A) {
      xorResult ^= x;
    }

    return xorResult != 0;
  }
}
