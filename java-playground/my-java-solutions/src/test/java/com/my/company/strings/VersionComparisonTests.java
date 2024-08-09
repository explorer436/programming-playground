package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionComparisonTests {

    VersionComparison versionComparison = new VersionComparison();

    @Test
    void test_equality() {
        int actual = versionComparison.compareVersions("3.5.18", "3.5.18");
        assertEquals(0, actual);
    }

    @Test
    void test_major_version_is_greater() {
        int actual = versionComparison.compareVersions("3.5.18", "2.5.18");
        assertEquals(1, actual);
    }

    @Test
    void test_minor_version_is_greater() {
        int actual = versionComparison.compareVersions("3.5.18", "3.4.18");
        assertEquals(1, actual);
    }

    @Test
    void test_patch_version_is_greater() {
        int actual = versionComparison.compareVersions("3.5.1", "3.5.0");
        assertEquals(1, actual);
    }

    @Test
    void test_major_version_is_lesser() {
        int actual = versionComparison.compareVersions("3.5.18", "4.5.18");
        assertEquals(-1, actual);
    }

    @Test
    void test_minor_version_is_lesser() {
        int actual = versionComparison.compareVersions("3.5.18", "3.6.18");
        assertEquals(-1, actual);
    }

    @Test
    void test_patch_version_is_lesser() {
        int actual = versionComparison.compareVersions("3.5.1", "3.5.2");
        assertEquals(-1, actual);
    }
}
