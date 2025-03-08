package com.my.company.datastructures.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IteratingAHashMap {

  public static void main(String[] args) {

    Map<String, String> sampleMap = new HashMap<String, String>();

    sampleMap.put("John Smith", "521-1234");
    sampleMap.put("Sam Doe", "521-5030");
    sampleMap.put("Sandra Dee", "521-9655");

    /**
     * Use enhanced for loop on the HashMap's EntrySet.
     * entrySet() is used to return a set view of mapped
     * elements. Use set.getKey() to get key from the set. Use set.getValue() to get value from the
     * set.
     */
    System.out.println("");
    System.out.println("Running a for loop on the EntrySet");
    for (Map.Entry<String, String> set : sampleMap.entrySet()) {
      System.out.println(set.getKey() + " = " + set.getValue());
    }

    // Using Stream API on the map's entrySet()
    System.out.println("");
    System.out.println("Using Stream API on the map's entrySet()");
    sampleMap.entrySet().stream()
            .forEach(input -> System.out.println(input.getKey() + " : " + input.getValue()));

    // using a lambda expression
    System.out.println("");
    System.out.println("using a lambda expression");
    sampleMap.forEach((key, value) -> System.out.println(key + " = " + value));

    // Using Iterator on the map's entrySet()
    System.out.println("");
    System.out.println("using Iterator on EntrySet");
    Iterator<Entry<String, String>> entrySet_Iterator = sampleMap.entrySet().iterator();
    while (entrySet_Iterator.hasNext()) {
      Map.Entry<String, String> new_Map = entrySet_Iterator.next();
      System.out.println(new_Map.getKey() + " = " + new_Map.getValue());
    }

    /**
     * Iterate through a HashMap using KeySet. keySet() returns a set of keys. Use each of the keys
     * in the set to get values from the map.
     */
    System.out.println("");
    System.out.println("using KeySet");
    for (String key : sampleMap.keySet()) {
      System.out.println(key + " = " + sampleMap.get(key));
    }
  }
}
