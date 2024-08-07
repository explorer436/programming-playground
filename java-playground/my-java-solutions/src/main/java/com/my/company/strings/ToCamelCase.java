package com.my.company.strings;

import java.util.List;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel
 * casing. The first word within the output should be capitalized only if the original word was
 * capitalized (known as Upper Camel Case, also often referred to as Pascal case). Examples
 *
 * <p>toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"
 *
 * <p>toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
 */
public class ToCamelCase {

    // This approach needs just one pass through the entire string.
    // Convert the initial string into a StringBuffer and manipulate the StringBuffer.
    public static String toCamelCase(String s) {
        StringBuffer sb = new StringBuffer(s);

        List<Character> charactersThatNeedToBeRemoved = List.of('_', '-', ' ');

        for (int i = 0; i < sb.length(); i++) {
            if (charactersThatNeedToBeRemoved.contains(sb.charAt(i))) {
                sb.setCharAt(i + 1, Character.toUpperCase((sb.charAt(i + 1))));
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    // Trying functional programming approach.
    // Apply a series of functions to get the final result.

    // This approach needs multiple passes through the entire string - so it will be slower compared
    // to toCamelCase().
    public static String toCamelCase2(String s) {
        return replaceByDelimiters(replaceByDelimiters(s, "_"), "-");
    }

    private static String replaceByDelimiters(String s, String stringToBeReplaced) {
        if (s.contains(stringToBeReplaced)) {
            String[] values = s.split(stringToBeReplaced);

            StringBuffer sb = new StringBuffer();
            sb.append(values[0]);
            for (int i = 1; i < values.length; i++) {
                sb.append(values[i].substring(0, 1).toUpperCase() + values[i].substring(1));
            }

            return sb.toString();
        } else {
            return s;
        }
    }
}
