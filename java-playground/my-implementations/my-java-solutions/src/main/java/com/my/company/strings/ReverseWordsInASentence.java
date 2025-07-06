package com.my.company.strings;

import org.apache.commons.lang3.StringUtils;

public class ReverseWordsInASentence {

    /**
     * Apache Commons has a utility method for this.
     *
     * <p>StringUtils.reverseDelimited(sentence, ' ');
     */

    public String reverseWordsInASentence(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            StringBuilder output = new StringBuilder();

            String[] words = sentence.split(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                output.append(words[i]);
                output.append(" ");
            }

            return output.toString().trim();
        }
        return sentence;
    }
}
