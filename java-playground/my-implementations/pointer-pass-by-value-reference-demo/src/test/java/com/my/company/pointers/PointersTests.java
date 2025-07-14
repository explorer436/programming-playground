package com.my.company.pointers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointersTests {
    @Test
    public void testPointers() {

        /*
         * Primitive types
         */

        int num1 = 11;

        // Not working with a pointer
        int num2 = num1;

        assertEquals(num1, 11);
        assertEquals(num2, 11);

        num1 = 22;

        assertEquals(num1, 22);
        assertEquals(num2, 11);

        //--------------------------------------------

        /*
         * Reference types - example using maps
         */

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("value", 15);

        // map2 points to map1 - points to the exact hash for map1 in memory
        Map<String, Integer> map2 = map1;

        assertEquals(map1.get("value"), 15);
        assertEquals(map2.get("value"), 15);

        map1.put("value", 20);

        assertEquals(map1.get("value"), 20);
        assertEquals(map2.get("value"), 20);

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("value", 57);

        assertEquals(map1.get("value"), 20);
        assertEquals(map2.get("value"), 20);
        assertEquals(map3.get("value"), 57);

        map2 = map3;
        assertEquals(map1.get("value"), 20);
        assertEquals(map2.get("value"), 57);
        assertEquals(map3.get("value"), 57);

        map1 = map2;
        assertEquals(map1.get("value"), 57);
        assertEquals(map2.get("value"), 57);
        assertEquals(map3.get("value"), 57);

        // The previous value for map1 (value=20) is now eligible for garbage collection

        //--------------------------------------------

        /*
         * Reference types - example using strings
         */

        String s = new String( "Hello" );
        assertEquals(s, "Hello");
        change(s);
        assertEquals(s, "Hello");

        StringWrapper sw = new StringWrapper();
        sw.s = "Hello";
        changeString(sw);
        assertEquals(sw.s, "Hello World");
    }

    public void change( String t )
    {
        assertEquals(t, "Hello");
        t = new String( "World" );
        assertEquals(t, "World");
    }

    class StringWrapper
    {
        public String s;
    }

    void changeString( StringWrapper t )
    {
        t.s += " World";
    }
}
