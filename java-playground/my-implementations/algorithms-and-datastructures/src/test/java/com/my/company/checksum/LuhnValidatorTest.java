package com.my.company.checksum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnValidatorTest {

    LuhnValidator luhnValidator = new LuhnValidator();

    @Test
    void isValid() {
        assertAll(
                () -> assertTrue(luhnValidator.isValid("79927398713")),
                () -> assertFalse(luhnValidator.isValid("12345"))
        );

    }
}