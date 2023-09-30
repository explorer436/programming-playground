package com.my.company.utility;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrintUtils {

  public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      if (pair.getValue() instanceof List) {
        System.out.println(
            pair.getKey() + " = " + Arrays.toString(((List) pair.getValue()).toArray()));
      } else {
        System.out.println(pair.getKey() + " = " + pair.getValue());
      }
    }
  }

  public static String print2DArray(int[][] array) {
    return java.util.Arrays.deepToString(array)
        .replace("], ", "]\n")
        .replace("[[", "[")
        .replace("]]", "]");
  }

  public static void printList(List<?> list) {
    /*
    for (int i = 0; i < intArray.length; i++)
    {
    	System.out.print(intArray[i] + "\t");
    }
    */

    // System.out.println(Arrays.toString(array));

    System.out.println(Arrays.deepToString(list.toArray()));
  }

  public static void printArray(Object[] array) {
    /*
    for (int i = 0; i < intArray.length; i++)
    {
    	System.out.print(intArray[i] + "\t");
    }
    */

    // System.out.println(Arrays.toString(array));

    System.out.println(Arrays.deepToString(array));
  }

  /** The method above will not work for primitive datatypes. */
  public static void printArray(int[] array) {
    /*
    for (int i = 0; i < intArray.length; i++)
    {
    	System.out.print(intArray[i] + "\t");
    }
    */

    System.out.println(Arrays.toString(array));
  }
}
