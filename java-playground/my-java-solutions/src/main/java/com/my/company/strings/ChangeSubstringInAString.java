package com.my.company.strings;

import org.apache.commons.lang3.StringUtils;

public class ChangeSubstringInAString {
    public String changeSubstringInAString(String substr, String actualString, String changeTo) {

        if (StringUtils.isEmpty(actualString)) {
            return "";
        }

        if (actualString.startsWith(substr)) {
            return changeSubstringInAString(substr,  changeTo + actualString.substring(substr.length(), actualString.length()), changeTo);
        }


            return actualString.substring(0,1) + changeSubstringInAString(substr,  actualString.substring(1, actualString.length()), changeTo);

    }
}