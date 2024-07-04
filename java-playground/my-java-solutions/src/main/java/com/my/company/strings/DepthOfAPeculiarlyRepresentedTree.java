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

        String changedInput = "";
        if (StringUtils.contains(input, "((00)(00))")) {
            // replace
            changedInput = changeSubstringInAString.changeSubstringInAString("((00)(00))", input, changeTo);
        } else {
            changedInput = input;
        }

        int resultFromHelper = helper(substr, changedInput, changeTo, countNumberOfOccurancesOfSubstringInAString, changeSubstringInAString);

        return resultFromHelper;

    }

    private int helper(String substr, String input, String changeTo, CountNumberOfOccurancesOfSubstringInAString countNumberOfOccurancesOfSubstringInAString, ChangeSubstringInAString changeSubstringInAString) {
        if (StringUtils.equalsIgnoreCase(substr, input)) {
            return 0;
        }

        int count = countNumberOfOccurancesOfSubstringInAString.countNumberOfOccurancesOfSubstringInAString(substr, input);

        int depth = depthOfAPeculiarlyRepresentedTree(substr, changeSubstringInAString.changeSubstringInAString(substr, input, changeTo), changeTo);

        return count + depth;
    }

}
