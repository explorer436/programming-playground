package com.my.company.numbers;

public class IntegerPalindrome {

  public static void main(String[] args) throws Exception {
    boolean result;

    result = isPalindrome(121);
    if (!result) {
      throw new Exception("wrong answer - expected true but received " + result);
    }

    result = isPalindrome(-121);
    if (result) {
      throw new Exception("wrong answer - expected false but received " + result);
    }

    result = isPalindrome(10);
    if (result) {
      throw new Exception("wrong answer - expected false but received " + result);
    }

    // ----------------------------------------------------------

    result = isPalindrome_UsingStringConversion(121);
    if (!result) {
      throw new Exception("wrong answer - expected true but received " + result);
    }

    result = isPalindrome_UsingStringConversion(-121);
    if (result) {
      throw new Exception("wrong answer - expected false but received " + result);
    }

    result = isPalindrome_UsingStringConversion(10);
    if (result) {
      throw new Exception("wrong answer - expected false but received " + result);
    }

    System.out.println("done");
  }

  /**
   * REMEMBER : do not try to do it all in one method. Break it down into smaller methods wherever
   * necessary.
   */
  public static boolean isPalindrome(int x) {
    boolean result = false;

    if (x >= 0) {
      result =
              x == new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(x);
    }

    return result;
  }

  /**
   * This method is not incorrect. We are not using String's native operations like
   * StringBuffer.reverse() for reversing the string. But, it would be nice to do it without
   * converting the integer into a String in the first place.
   */
  public static boolean isPalindrome_UsingStringConversion(int x) {

    if (x < 0) {
      return false;
    }

    String initialIntInStringForm = String.valueOf(x);

    if (initialIntInStringForm.equals(reverseStringUsingByteArray(initialIntInStringForm))) {
      return true;
    } else {
      return false;
    }
  }

  /** Take a look at StringReversal.java */
  public static String reverseStringUsingByteArray(String input) {
    String reversedString = null;

    if (input != null) {
      byte[] strAsByteArray = input.getBytes();

      byte[] result = new byte[strAsByteArray.length];

      // Store result in reverse order into result byte[]
      for (int i = 0; i < strAsByteArray.length; i++) {
        result[i] = strAsByteArray[strAsByteArray.length - i - 1];
      }

      reversedString = new String(result);
    }

    return reversedString;
  }
}
