package com.my.company.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

import java.nio.charset.StandardCharsets;

/**
 * Reverse the characters in a String
 */
public class StringReversal {

    /**
     * Using String.toCharArray()
     */
    public String reverseStringUsingCharArray1(String input) {
        if (StringUtils.isNotEmpty(input)) {

            char[] charArray = input.toCharArray();
            int length = input.length(), last = length - 1;

            for ( int i = 0; i < length/2; i++ ) {
                char c = charArray[i];
                charArray[i] = charArray[last - i];
                charArray[last - i] = c;
            }

            return new String(charArray);
        }
        return input;
    }

    /**
     * Using String.toCharArray()
     */
    public String reverseStringUsingCharArray2(String input) {
        if (StringUtils.isNotEmpty(input)) {
            char[] charArray = input.toCharArray();
            int left, right = 0;
            right = charArray.length - 1;

            for (left = 0; left < right; left++, right--) {
                // Swap values of left and right
                // ArrayUtils.swap()
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
            }

            return new String(charArray);
        }
        return input;
    }

    // recursion
    public String reverseStringUsingRecursion(String str) {
        if (StringUtils.isNotEmpty(str)) {
            return str.substring(str.length() - 1) + reverseStringUsingRecursion(str.substring(0, str.length() - 1));
        }
        return str;
    }

    public String reverseStringUsingWhileLoop(String input) {

        if (StringUtils.isNotEmpty(input)) {
            StringBuffer sb = new StringBuffer();
            int length = input.length();
            while (length > 0) {
                sb.append(input.substring(length - 1, length));
                length = length - 1;
            }
            return sb.toString();
        }
        return input;
    }

    /**
     * Using a for loop
     */
    public String reverseStringUsingForLoop(String input) {

        if (StringUtils.isNotEmpty(input)) {
            String output = "";

            for (int i = input.length() - 1; i >= 0; i--) {
                output = output + input.charAt(i);
            }
            return output;
        }

        return input;
    }

    /**
     * Using String.getBytes()
     */
    public String reverseStringUsingByteArray(String input) {
        if (StringUtils.isNotEmpty(input)) {

            byte[] strAsByteArray = input.getBytes();

            byte[] result = new byte[strAsByteArray.length];

            // Store result in reverse order into result byte[]
            for (int i = 0; i < strAsByteArray.length; i++) {
                result[i] = strAsByteArray[strAsByteArray.length - i - 1];
            }

            return new String(result, StandardCharsets.UTF_8);
        }
        return input;
    }

    /**
     * Using StringBuilder.reverse()
     */
    public String reverseStringUsingStringBuilder(String input) {
        if (StringUtils.isNotEmpty(input)) {
            StringBuilder output = new StringBuilder(input).reverse();

            return output.toString();
        }
        return input;
    }

    /**
     * Using Collections.reverse()
     */
    public String reverseStringUsingCollections(String input) {
        if (StringUtils.isNotEmpty(input)) {

            char[] hello = input.toCharArray();
            List<Character> trial1 = new ArrayList<>();

            for (char c : hello) {
                trial1.add(c);
            }

            Collections.reverse(trial1);

            StringBuffer sb = new StringBuffer();
            ListIterator li = trial1.listIterator();
            while (li.hasNext()) {
                sb.append(li.next());
            }
            return sb.toString();
        }
        return input;
    }

    // Note : Apache Commons has a helper method for this as well. StringUtils.reverse()
    public String reverseStringUsingApacheCommonsLibrary(String str) {
        if (StringUtils.isNotEmpty(str)) {
            return StringUtils.reverse(str);
        }
        return str;
    }
}
