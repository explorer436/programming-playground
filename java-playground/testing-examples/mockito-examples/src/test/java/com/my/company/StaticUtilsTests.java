package com.my.company;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaticUtilsTests {

    @Test
    void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {

        assertEquals(StaticUtils.name(), "a-name");

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(StaticUtils::name).thenReturn("some-other-name");
            assertEquals(StaticUtils.name(), "some-other-name");
        }

        assertEquals(StaticUtils.name(), "a-name");
    }

    @Test
    void givenStaticMethodWithArgs_whenMocked_thenReturnsMockSuccessfully() {
        assertTrue(StaticUtils.range(2, 6).contains(2));
        assertTrue(StaticUtils.range(2, 6).contains(3));
        assertTrue(StaticUtils.range(2, 6).contains(4));
        assertTrue(StaticUtils.range(2, 6).contains(5));

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(() -> StaticUtils.range(2, 6))
                    .thenReturn(Arrays.asList(10, 11, 12));

            assertTrue(StaticUtils.range(2, 6).contains(10));
            assertTrue(StaticUtils.range(2, 6).contains(11));
            assertTrue(StaticUtils.range(2, 6).contains(12));
        }

        assertTrue(StaticUtils.range(2, 6).contains(2));
        assertTrue(StaticUtils.range(2, 6).contains(3));
        assertTrue(StaticUtils.range(2, 6).contains(4));
        assertTrue(StaticUtils.range(2, 6).contains(5));
    }

}
