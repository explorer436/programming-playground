package com.my.company.strings;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class StringPalindrome {

  public boolean isPalindrome_caseSensitive(String word) {

    boolean result = true;

    for (int i = 0; i < word.length(); i++) {
      int oppositeIndex = word.length() - (i + 1);

      char a = word.charAt(i);
      char b = word.charAt(oppositeIndex);

      if (a != b) {
        result = false;
        break;
      }
    }

    return result;
  }

  public boolean isPalindrome_caseInsensitive(String word) {

    boolean result = true;

    for (int i = 0; i < word.length(); i++) {
      int oppositeIndex = word.length() - (i + 1);

      char a = word.charAt(i);
      char b = word.charAt(oppositeIndex);

      a = Character.toLowerCase(a);
      b = Character.toLowerCase(b);

      if (a != b) {
        result = false;
        break;
      }
    }

    return result;
  }

  public boolean isPalindrome_usingStack(String string) {

    LinkedList<Character> stack = new LinkedList<>();

    StringBuilder stringNoPunctuation = new StringBuilder(string.length());
    String lowerCase = string.toLowerCase();

    for (int i = 0; i < lowerCase.length(); i++) {
      char c = lowerCase.charAt(i);

      if (c >= 'a' && c <= 'z') {
        stack.push(c);
        stringNoPunctuation.append(c);
      }
    }

    StringBuilder reversedString = new StringBuilder(string.length());
    while (!stack.isEmpty()) {
      reversedString.append(stack.pop());
    }

    return reversedString.toString().contentEquals(stringNoPunctuation);
  }

  public boolean isPalindrome_usingStackAndQueue(String string) {

    LinkedList<Character> stack = new LinkedList<>();
    ArrayDeque<Character> queue = new ArrayDeque<>();

    String lowerCase = string.toLowerCase();

    for (int i = 0; i < lowerCase.length(); i++) {
      char c = lowerCase.charAt(i);

      if (c >= 'a' && c <= 'z') {
        stack.push(c);
        queue.addLast(c);
      }
    }

    StringBuilder reversedString = new StringBuilder(string.length());
    while (!stack.isEmpty()) {
      reversedString.append(stack.pop());
    }

    StringBuilder initialStringQithoutPunctuation = new StringBuilder(string.length());
    while (!queue.isEmpty()) {
      initialStringQithoutPunctuation.append(queue.removeFirst());
    }

    return reversedString.toString().equals(initialStringQithoutPunctuation.toString());
  }
}
