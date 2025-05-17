package com.my.company.strings;

public class Staircase {

  public static void main(String[] args) {
    staircase(4);
    staircase(6);
  }

  static void staircase(int n) {

    String whitespace = " ";
    String hashSymbol = "#";

    for (int i = 1; i <= n; i++) {
      int numberOfWhiteSpaces = n - i;
      System.out.print(new String(new char[numberOfWhiteSpaces]).replace("\0", whitespace));

      int numberOfHashes = i;
      System.out.println(new String(new char[numberOfHashes]).replace("\0", hashSymbol));
    }
  }
}
