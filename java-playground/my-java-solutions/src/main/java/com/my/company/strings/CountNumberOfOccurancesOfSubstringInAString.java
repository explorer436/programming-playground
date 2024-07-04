package com.my.company.strings;

import org.apache.commons.lang3.StringUtils;

public class CountNumberOfOccurancesOfSubstringInAString {
    public int countNumberOfOccurancesOfSubstringInAString(String substr, String actualString) {
        if (StringUtils.isEmpty(actualString)) {
            return 0;
        }

        if (actualString.startsWith(substr)) {
            return 1 + countNumberOfOccurancesOfSubstringInAString(substr, actualString.substring(substr.length(), actualString.length()));
        } else {
            return countNumberOfOccurancesOfSubstringInAString(substr, actualString.substring(1, actualString.length()));
        }
    }
}
