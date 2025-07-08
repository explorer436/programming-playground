package com.my.company.datastructures.maps;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BagOfWords {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("daily", "interview", "pro", "pro", "for", "daily", "pro", "problems", "for"));

        System.out.println(getOccurancesCountUsingStreamsCollectorsCounting(l));

        System.out.println(getSortedOccurancesCountUsingForLoop(l));

        System.out.println(getOccurancesCountUsingForLoop(l));
    }

    // Using streams collectors counting
    public static Map<String, Long> getOccurancesCountUsingStreamsCollectorsCounting(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        item -> item, // or Function.identity()
                        Collectors.counting()
                ));
    }

    // sorted because we are using TreeMap
    public static Map<String, Long> getSortedOccurancesCountUsingForLoop(List<String> list) {

        Map<String, Long> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            Long previousCount = map.getOrDefault(list.get(i), 0L);
            map.put(list.get(i), previousCount + 1);
        }
        return map;
    }

    public static Map<String, Long> getOccurancesCountUsingForLoop(List<String> list) {

        Map<String, Long> map = new ConcurrentHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Long previousCount = map.getOrDefault(list.get(i), 0L);
            map.put(list.get(i), previousCount + 1);
        }
        return map;
    }
}
