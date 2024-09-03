package com.my.company.streamsapi;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class LimitAndSkip {
    public static void main(String[] args) {
        limit();
        skip();
    }

    private static void limit() {
        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);

        List<Integer> newList = evenNumInfiniteStream
                .limit(10)
                .collect(Collectors.toList());

        log.info(newList.toString());
        // [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
    }

    private static void skip() {
        List<Integer> newList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .skip(6)
                .collect(Collectors.toList());

        log.info(newList.toString());
        // [7, 8, 9, 10]
    }
}
