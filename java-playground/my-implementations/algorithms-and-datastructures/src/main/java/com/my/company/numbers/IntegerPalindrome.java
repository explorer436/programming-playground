package com.my.company.numbers;

public class IntegerPalindrome {

  /**
   * REMEMBER : do not try to do it all in one method. Break it down into smaller methods wherever
   * necessary.
   */
  public boolean isPalindrome(int x) {
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
  public boolean isPalindrome_UsingStringConversion(int x) {

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
  public String reverseStringUsingByteArray(String input) {
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
