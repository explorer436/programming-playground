package com.my.company.strings;

/**
 * Write a function that compares two version strings.
 * Strings are in the format [major].[minor].[patch], e.g. 3.5.18
 * It should return -1 if version1 < version2, 1 if version1 > version2, and 0 if they are equal.
 * Note: you can assume all versions will follow the [major].[minor].[patch] format
 */
public class SemanticVersionComparator {
    // "3.5.18" = "3.5.18" = equality condition

    // "3.5.1" > "2.5.1" = major version check
    // "3.5.1" > "3.4.1" = minor version check
    // "3.5.1" > "3.5.0" = patch version check

    public int compare(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }

        String[] str1Parts = str1.split("\\.");
        String[] str2Parts = str2.split("\\.");

        for (int i=0; i <= str1Parts.length; i++) {
            int comparisonResult = helper(str1Parts[i], str2Parts[i]);
            if (comparisonResult != 0) {
                return comparisonResult;
            }
        }

        return -1;
    }

    private static int helper(String str1Part, String str2Part) {

        if (Integer.parseInt(str1Part) == Integer.parseInt(str2Part)) {
            return 0;
        } else if (Integer.parseInt(str1Part) > Integer.parseInt(str2Part)) {
            return 1;
        } else if (Integer.parseInt(str1Part) < Integer.parseInt(str2Part)) {
            return -1;
        }

        return -1;
    }

}
