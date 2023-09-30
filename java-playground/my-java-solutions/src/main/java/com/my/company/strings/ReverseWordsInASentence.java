package com.my.company.strings;

public class ReverseWordsInASentence {

  /**
   * Apache Commons has a utility method for this.
   *
   * <p>StringUtils.reverseDelimited(sentence, ' ');
   */
  public static void main(String[] args) {
    reverseWordsInASentence("This is a test.");
  }

  public static void reverseWordsInASentence(String sentence) {
    if (sentence != null) {
      StringBuilder output = new StringBuilder();

      String[] words = sentence.split(" ");
      for (int i = words.length - 1; i >= 0; i--) {
        output.append(words[i]);
        output.append(" ");
      }

      System.out.println(output.toString().trim());
    }
  }
}
