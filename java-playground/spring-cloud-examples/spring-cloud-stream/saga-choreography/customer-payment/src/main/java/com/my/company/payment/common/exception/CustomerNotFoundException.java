package com.my.company.payment.common.exception;

public class CustomerNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Customer not found";

    public CustomerNotFoundException() {
        super(MESSAGE);
    }

}