package com.my.company.streamsapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    public static String joinListGrammaticallyWithJava(List<String> msgs) {
        int size = msgs == null ? 0 : msgs.size();
        if (size == 0) {
            return "";
        }

        if (size == 1) {
            return msgs.get(0);
        }

        return String.join(", ", msgs.subList(0, --size)) + " and " + msgs.get(size);
    }

    /**
     * Joining collector can be used for joining Stream<String> elements.
     */
    public static String collect_Joining(List<String> givenList) {

        return givenList.stream().collect(Collectors.joining());
    }

    // This seems to be doing the same thing as above.
    public static String collect_Joining_CustomSeparators_withoutStreams(List<String> givenList) {

        return String.join(", ", givenList);
    }

    public static String collect_Joining_CustomSeparators(List<String> givenList, String separator) {

        return givenList.stream().collect(Collectors.joining(separator));
    }

    public static String collect_Joining_CustomSeparators_NumberedList(List<String> givenList) {
        ArrayList<String> inputList = new ArrayList<>(givenList);

        for (int i = 0; i < inputList.size(); i++) {
            inputList.set(i, i + 1 + ". " + inputList.get(i));
        }

        return inputList.stream()
                .collect(Collectors.joining(", ", "This list has the following elements - ", ""));
    }

    public static String collect_JoiningWithPreAndPost(List<String> givenList) {

        return givenList.stream().collect(Collectors.joining(", ", "PRE-", "-POST"));
    }
}
