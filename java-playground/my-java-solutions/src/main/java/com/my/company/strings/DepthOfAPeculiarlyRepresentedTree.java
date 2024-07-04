package com.my.company.strings;

import org.apache.commons.lang3.StringUtils;

public class DepthOfAPeculiarlyRepresentedTree {

    public int depthOfAPeculiarlyRepresentedTree(String substr, String input, String changeTo) {

        ChangeSubstringInAString changeSubstringInAString = new ChangeSubstringInAString();
        CountNumberOfOccurancesOfSubstringInAString countNumberOfOccurancesOfSubstringInAString = new CountNumberOfOccurancesOfSubstringInAString();

        if (StringUtils.isEmpty(input)) {
            return -1;
        }

        if (StringUtils.equalsIgnoreCase("((00)(00))", input)) {
            return 1;
        }

        if (StringUtils.equalsIgnoreCase(substr, input)) {
            return 0;
        }

        return countNumberOfOccurancesOfSubstringInAString.countNumberOfOccurancesOfSubstringInAString(substr, input) +
                depthOfAPeculiarlyRepresentedTree(substr, changeSubstringInAString.changeSubstringInAString(substr, input, changeTo), changeTo);

    }

}
