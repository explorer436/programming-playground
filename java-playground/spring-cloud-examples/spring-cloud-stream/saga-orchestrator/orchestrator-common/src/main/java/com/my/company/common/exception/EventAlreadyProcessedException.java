package com.my.company.common.exception;

public class EventAlreadyProcessedException extends RuntimeException {

    private static final String MESSAGE = "The event is already processed";

    public EventAlreadyProcessedException() {
        super(MESSAGE);
    }
}
