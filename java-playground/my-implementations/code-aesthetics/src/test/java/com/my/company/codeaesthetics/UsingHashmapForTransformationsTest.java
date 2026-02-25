package com.my.company.codeaesthetics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsingHashmapForTransformationsTest {

    UsingHashmapForTransformations usingHashmapForTransformations = new UsingHashmapForTransformations();

    @Test
    void transformation_using_if_else() {
        assertEquals(new UsingHashmapForTransformations.MyAddress("usa-address-line-1", "usa-city", "usa-state", "usa-zip-code"), usingHashmapForTransformations.transformation_using_if_else("USA"));
        assertEquals(new UsingHashmapForTransformations.MyAddress("canada-address-line-1", "canada-city", "canada-state", "canada-zip-code"), usingHashmapForTransformations.transformation_using_if_else("Canada"));
    }

    @Test
    void transformation_using_map() {
        assertEquals(new UsingHashmapForTransformations.MyAddress("usa-address-line-1", "usa-city", "usa-state", "usa-zip-code"), usingHashmapForTransformations.transformation_using_map("USA"));
        assertEquals(new UsingHashmapForTransformations.MyAddress("canada-address-line-1", "canada-city", "canada-state", "canada-zip-code"), usingHashmapForTransformations.transformation_using_map("Canada"));
    }
}