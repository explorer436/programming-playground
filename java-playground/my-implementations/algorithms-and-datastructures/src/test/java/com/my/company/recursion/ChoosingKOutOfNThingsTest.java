package com.my.company.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoosingKOutOfNThingsTest {

    ChoosingKOutOfNThings choosingKOutOfNThings = new ChoosingKOutOfNThings();

    @Test
    void getNumberOfGroups() {
        assertEquals(10, choosingKOutOfNThings.getNumberOfGroups(5, 2));
    }
}