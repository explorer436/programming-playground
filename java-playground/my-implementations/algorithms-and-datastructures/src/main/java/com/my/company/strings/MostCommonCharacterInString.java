package com.my.company.strings;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MostCommonCharacterInString {

    /**
     * approach 1: build a hashmap with each of the letters and then loop through the values for each
     * character to see which one is the greatest.
     */
    public HashMap<Character, Integer> getMapOfLetters(String str) {
        HashMap<Character, Integer> letterCountMap = new HashMap<>();

        Integer currentCount;
        if (null != str) {
            for (char c : str.toCharArray()) {
                currentCount = letterCountMap.get(c);

                if (currentCount == null) {
                    letterCountMap.put(c, 1);
                } else {
                    currentCount = currentCount + 1;
                    letterCountMap.put(c, currentCount);
                }
            }
        }

        return letterCountMap;
    }

    public String mostCommonCharacters1(String str) {
        HashMap<Character, Integer> letterCountMap = getMapOfLetters(str);

        List<Character> mostCommonCharactersList = List.of();

        // PrintUtils.printMap(letterCountMap);

        // The first step is to find the highest value at all.
        if (!letterCountMap.isEmpty()) {
            int maxValue = Collections.max(letterCountMap.values());

            // Now iterate through all the entries of the map and add to the list keys associated with the
            // highest value.
            mostCommonCharactersList = new ArrayList<>();
            for (Entry<Character, Integer> entry : letterCountMap.entrySet()) {
                if (entry.getValue() == maxValue) {
                    mostCommonCharactersList.add(entry.getKey());
                }
            }
        }

        return mostCommonCharactersList;
    }

    public String mostCommonCharacters2(String str) {
        HashMap<Character, Integer> letterCountMap = getMapOfLetters(str);

        // PrintUtils.printMap(letterCountMap);

        // The first step is to find the highest value at all.
        if (!letterCountMap.isEmpty()) {
            int maxValue = Collections.max(letterCountMap.values());

            // using streams
            List<Character> listRetrievedUsingStreams =
                    letterCountMap.entrySet().stream()
                            .filter(entry -> entry.getValue() == maxValue)
                            .map(entry -> entry.getKey())
                            .collect(Collectors.toList());

            System.out.println(
                    "MostCommonCharacterInString : " + Arrays.toString(listRetrievedUsingStreams.toArray()));
        }
        return null;
    }

    public char firstMostCommonCharacter(String str) {
        HashMap<Character, Integer> letterCountMap = getMapOfLetters(str);

        // PrintUtils.printMap(letterCountMap);

        // The first step is to find the highest value at all.
        if (!letterCountMap.isEmpty()) {
            int maxValue = Collections.max(letterCountMap.values());

            // Now iterate through all the entries of the map and add to the list keys associated with the
            // highest value.
            List<Character> mostCommonCharactersList = new ArrayList<>();
            for (Entry<Character, Integer> entry : letterCountMap.entrySet()) {
                if (entry.getValue() == maxValue) {
                    mostCommonCharactersList.add(entry.getKey());
                    break;
                }
            }

            System.out.println(
                    "MostCommonCharacterInString : " + Arrays.toString(mostCommonCharactersList.toArray()));

            // using streams
            List<Character> listRetrievedUsingStreams =
                    letterCountMap.entrySet().stream()
                            .filter(entry -> entry.getValue() == maxValue)
                            .map(entry -> entry.getKey())
                            .collect(Collectors.toList());

            System.out.println("MostCommonCharacterInString : " + listRetrievedUsingStreams.get(0));

            return listRetrievedUsingStreams.get(0);
        }

        return 0;
    }

}
