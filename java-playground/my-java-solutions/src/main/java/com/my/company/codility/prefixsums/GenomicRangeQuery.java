package com.my.company.codility.prefixsums;

import com.my.company.utility.PrintUtils;

public class GenomicRangeQuery {

  public static void main(String[] args) {
    for (int i : solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6})) {
      System.out.println("result i : " + i);
    }

    // System.out.println("result : " + solution(6, 11, 3));

    // System.out.println("result : " + solution(11, 345, 17));//answer should be 20

    /*
     * A = 11, B = 345, K = 17 WRONG ANSWER got 19 expected 20
     */

    /*
     * System.out.println("result : " + solution(2, A3));
     *
     * System.out.println("result : " + solution(3, A4));
     *
     * System.out.println("result : " + solution(1, A5));
     *
     * System.out.println("result : " + solution(2, A5));
     */
  }

  public static int[] solution(String S, int[] P, int[] Q) {

    char[] chars_from_s_array = S.toCharArray();
    System.out.println("chars_from_s_array.length : " + chars_from_s_array.length);

    // 4 X 8 array
    // 4 columns - each column for each letter A, C, G, T
    // 8 rows
    int[][] cumulativeAnswers = new int[chars_from_s_array.length + 1][4];

    // run for loop on S = CAGCCTA
    for (int location_in_s_array = 0;
        location_in_s_array < chars_from_s_array.length;
        location_in_s_array++) {
      System.out.println(">>> location_in_s_array : " + location_in_s_array);

      // Leave the first row with all zeroes.
      // Do not change it.
      // We will use this to keep count of each char in the string
      if (location_in_s_array > 0) {
        copyRowToNextRow(cumulativeAnswers, location_in_s_array);

        System.out.println("cumulativeAnswers : ");
        System.out.println(PrintUtils.print2DArray(cumulativeAnswers));
      }

      incrementCountBasedOnLetterAtCurrentPostition(
          chars_from_s_array, cumulativeAnswers, location_in_s_array);

      // printing
      System.out.println(
          "after incrementing the letter count for location " + location_in_s_array + " - ");
      System.out.println(PrintUtils.print2DArray(cumulativeAnswers));
    }
    // end of the for loop for each letter in the string S

    // finally, populate an element at each location in answerArray
    return extractFinalAnswer(P, Q, cumulativeAnswers);
  }

  private static int[] extractFinalAnswer(int[] P, int[] Q, int[][] cumulativeAnswers) {
    // P.length = Q.length and this will be the length of the final answer array
    int[] answerArray = new int[P.length];

    // just subtract the values from the columns for each letter
    // to figure out if the letter is present within the limits
    for (int i = 0; i < P.length; i++) {
      // j stands for the letters A,C,G,T
      for (int j = 0; j < 4; j++) {
        if ((cumulativeAnswers[Q[i] + 1][j] - cumulativeAnswers[P[i]][j]) > 0) {
          answerArray[i] = j + 1;
          break;
        }
      }
    }

    return answerArray;
  }

  private static void incrementCountBasedOnLetterAtCurrentPostition(
      char[] chars_from_s_array, int[][] cumulativeAnswers, int location_in_s_array) {
    switch (chars_from_s_array[location_in_s_array]) {
      case 'A':
        cumulativeAnswers[location_in_s_array + 1][0] =
            cumulativeAnswers[location_in_s_array + 1][0] + 1;
        break;
      case 'C':
        cumulativeAnswers[location_in_s_array + 1][1] =
            cumulativeAnswers[location_in_s_array + 1][1] + 1;
        break;
      case 'G':
        cumulativeAnswers[location_in_s_array + 1][2] =
            cumulativeAnswers[location_in_s_array + 1][2] + 1;
        break;
      case 'T':
        cumulativeAnswers[location_in_s_array + 1][3] =
            cumulativeAnswers[location_in_s_array + 1][3] + 1;
        break;
    }
  }

  // just copy the previous row into the current row to preserve count
  private static void copyRowToNextRow(int[][] cumulativeAnswers, int location_in_s_array) {
    for (int eachLettersInDnaSequence = 0;
        eachLettersInDnaSequence < 4;
        eachLettersInDnaSequence++) {
      System.out.println("eachLettersInDnaSequence : " + eachLettersInDnaSequence);

      cumulativeAnswers[location_in_s_array + 1][eachLettersInDnaSequence] =
          cumulativeAnswers[location_in_s_array][eachLettersInDnaSequence];
    }
  }
}
