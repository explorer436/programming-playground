package com.my.company.checkingexceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExceptions {

    @Test
    public void whenExceptionThrown_thenAssertionExceptionMessage() {
        // Old way of doing it - if the application is not using the latest version of junit/jupiter
        try {
            Integer.parseInt("1a");
            // } catch (Exception e) {
        } catch (NumberFormatException e) {
            // catch a custom exception type if you know that your class will throw custom exception type
            String expected = "For input string: \"1a\"";
            String actual = e.getMessage();
            assertEquals(expected, actual);
            return;
        }
        // we should not reach this point at all.
        fail();
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
