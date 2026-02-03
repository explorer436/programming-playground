package com.my.company.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizingAParadeTest {

    OrganizingAParade organizingAParade = new OrganizingAParade();

    @Test
    void solve() {
        assertEquals(17711, organizingAParade.solve(20));
    }
}