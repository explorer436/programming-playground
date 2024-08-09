package com.my.company.strings;

/**
 * Write a function that compares two version strings.
 * Strings are in the format [major].[minor].[patch], e.g. 3.5.18
 * It should return -1 if version1 < version2, 1 if version1 > version2, and 0 if they are equal.
 * Note: you can assume all versions will follow the [major].[minor].[patch] format
 */
public class VersionComparison {
    // "3.5.18" = "3.5.18" = equality condition

    // "3.5.1" > "2.5.1" = major version check
    // "3.5.1" > "3.4.1" = minor version check
    // "3.5.1" > "3.5.0" = patch version check

    public int compareVersions(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }

        String[] str1Parts = str1.split("\\.");
        String[] str2Parts = str2.split("\\.");

        int majorVersionComparisonResult = extracted(str1Parts[0], str2Parts[0]);
        if (majorVersionComparisonResult != 0) {
            return majorVersionComparisonResult;
        }

        int minorVersionComparisonResult = extracted(str1Parts[1], str2Parts[1]);
        if (minorVersionComparisonResult != 0) {
            return minorVersionComparisonResult;
        }

        int patchVersionComparisonResult = extracted(str1Parts[2], str2Parts[2]);
        if (patchVersionComparisonResult != 0) {
            return patchVersionComparisonResult;
        }

        return -1;
    }

    private static int extracted(String str1Part, String str2Part) {

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
