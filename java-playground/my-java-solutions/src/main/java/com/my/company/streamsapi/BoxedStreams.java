package com.my.company.streamsapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxedStreams {
    public static void main(String[] args) {
        boxed();
    }

    private static void boxed() {
        Stream<Integer> stream = IntStream.of(1, 2, 3, 4, 5).boxed();

        //Compilation issue
        // List<Integer> list1 = IntStream.of(1,2,3,4,5).collect(Collectors.toList());

        //Works fine
        List<Integer> list2 = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .collect(Collectors.toList());
    }
}
