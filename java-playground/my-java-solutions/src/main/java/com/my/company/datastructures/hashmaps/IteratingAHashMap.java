package com.my.company.datastructures.hashmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class IteratingAHashMap {
    public static void main(String[] args) {
        Map<String, String> sampleMap = new HashMap<String, String>();
        sampleMap.put("A", "Angular");
        sampleMap.put("J", "Java");
        sampleMap.put("P", "Python");
        sampleMap.put("H", "Hibernate");

        /**
         * Iterate through a HashMap EntrySet using Iterators.
         * entrySet() is used to return a set view of mapped elements.
         * Use set.getValue() to get value from the set.
         * Use set.getKey() to get key from the set.
         */
        for (Map.Entry<String, String> set : sampleMap.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }

        // Using for-each loop on the entrySet
        for (Map.Entry<String, String> set : sampleMap.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }

        // using a lambda expression
        sampleMap.forEach((key, value) -> System.out.println(key + " = " + value));

        // Iterate through HashMap EntrySet using Iterator.
        Iterator<Entry<String, String>> entrySet_Iterator = sampleMap.entrySet().iterator();
        while (entrySet_Iterator.hasNext()) {
            Map.Entry<String, String> new_Map = (Map.Entry<String, String>) entrySet_Iterator.next();
            System.out.println(new_Map.getKey() + " = " + new_Map.getValue());
        }

        // Using Stream API on the map's entrySet()
        sampleMap.entrySet().stream().forEach(input -> System.out.println(input.getKey() + " : " + input.getValue()));
    }
}
