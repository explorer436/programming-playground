package com.my.company.sorting.sortbyenums;

import com.my.company.sorting.objects.Fruit;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortByEnumTests {

    @Test
    public void test_Comparable_compareTo_on_arrays() throws Exception {

        Person parent = Person.builder().name("A B").personRole(PersonRole.PARENT).build();
        Person grandparent = Person.builder().name("C D").personRole(PersonRole.GRANDPARENT).build();
        Person child = Person.builder().name("E F").personRole(PersonRole.CHILD).build();

        List<Person> unsortedPersonsList = Arrays.asList(parent, grandparent, child);

        // Before sorting
        assertEquals(parent, unsortedPersonsList.get(0));
        assertEquals(grandparent, unsortedPersonsList.get(1));
        assertEquals(child, unsortedPersonsList.get(2));

        List<Person> sortedPersonsList =
                unsortedPersonsList
                        .stream()
                        .sorted(Comparator.comparing(p -> p.getPersonRole().getHierarchy()))
                        .collect(Collectors.toList());

        // After sorting
        assertEquals(child, sortedPersonsList.get(0));
        assertEquals(parent, sortedPersonsList.get(1));
        assertEquals(grandparent, sortedPersonsList.get(2));
    }

}
