package com.my.company.common.exception;

/*
    With kafka, there is always a possibility of duplicate messages coming from the topic.
    This exception class is to handle those scenarios.
    This is used by DuplicateEventValidator.
 */
public class EventAlreadyProcessedException extends RuntimeException {

    private static final String MESSAGE = "The event is already processed";

    public EventAlreadyProcessedException() {
        super(MESSAGE);
    }
}
