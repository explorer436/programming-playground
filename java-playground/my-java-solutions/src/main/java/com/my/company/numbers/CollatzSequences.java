package com.my.company.numbers;

public class CollatzSequences {

  public static void main(String[] args) throws Exception {

    int result;

    result = getCollatzSequenceLength(13);
    if (10 != result) {
      throw new Exception("wrong answer - expected " + "10" + " but received " + result);
    }

    result = getCollatzSequenceLength(30);
    if (19 != result) {
      throw new Exception("wrong answer - expected " + "19" + " but received " + result);
    }

    System.out.println(
        "countOfIntegersForWhichChainLengthIsGreaterThan15 : "
            + countOfIntegersForWhichChainLengthIsGreaterThan15());

    printCollatzSequence(13);

    System.out.println("done");
  }

  private static int countOfIntegersForWhichChainLengthIsGreaterThan15() {
    int result = 0;

    for (int i = 1; i <= 100; i++) {
      if (getCollatzSequenceLength(i) > 15) {
        result = result + 1;
      }
    }

    return result;
  }

  private static int getCollatzSequenceLength(int number) {
    int chainLength = 1;

    while (number > 1) {
      chainLength = chainLength + 1;
      if (number % 2 == 0) {
        number = number / 2;
      } else {
        number = (number * 3) + 1;
      }
    }

    return chainLength;
  }

  private static void printCollatzSequence(int number) {
    System.out.println(">>> printing Collatz sequence for the number : " + number);
    if (number <= 0) {
      System.out.println("Input is invalid.");
    } else {
      System.out.print(number);
      while (number > 1) {
        System.out.print(" - ");
        if (number % 2 == 0) {
          number = number / 2;
        } else {
          number = (number * 3) + 1;
        }
        System.out.print(number);
      }
    }

    System.out.println("");
  }
}
