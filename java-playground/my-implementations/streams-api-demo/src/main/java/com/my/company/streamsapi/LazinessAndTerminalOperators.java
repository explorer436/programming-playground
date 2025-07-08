package com.my.company.streamsapi;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class LazinessAndTerminalOperators {

    public static void main(String[] args) {
        laziness();
        terminal_operators();
    }

    public static void laziness() {
        Stream.of(1)
                .peek(i -> log.info("received : {}", i));

        // This doesn't do anything.
    }

    public static void terminal_operators() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .peek(i -> log.info("received : {}", i))
                .toList();
    }
}


