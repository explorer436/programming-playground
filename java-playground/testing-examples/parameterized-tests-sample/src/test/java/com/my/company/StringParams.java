package com.my.company;

import java.util.stream.Stream;

// This is used in ParameterizedTestsWithMethodSource.java
// This can be shared by multiple test classes

public class StringParams {

    static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }
}
