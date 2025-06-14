package com.my.company.datastructures.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.my.company.datastructures.maps.BagOfWords.getSortedOccurancesCountUsingForLoop;

public class TopKFrequentWords {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("daily", "interview", "pro", "pro", "for", "daily", "pro", "problems", "for"));

        Map<String, Long> wordOccurancesMap = getSortedOccurancesCountUsingForLoop(l);

        Map<String, Long> abc = filterByValue(wordOccurancesMap, value -> value >= 2);

        System.out.println(abc);
    }

    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, java.util.function.Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(entry -> predicate.test(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
