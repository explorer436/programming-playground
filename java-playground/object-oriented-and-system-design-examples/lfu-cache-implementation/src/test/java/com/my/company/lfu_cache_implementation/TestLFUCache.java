package com.my.company.lfu_cache_implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLFUCache {

    @Test
    public void testLFUCache1() {
        int[] pageNumberArray = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};

        int cacheSize = 3;

        LFUCache lfuCache = new LFUCache(cacheSize);

        int hitCount = 0;
        int faultCount = 0;
        for (int key : pageNumberArray) {
            if (-1 != lfuCache.get(key)) {
                hitCount++;
            } else {
                faultCount++;
                lfuCache.put(key, key);
            }
        }

        assertEquals(2, hitCount);
        assertEquals(10, faultCount);
    }

    @Test
    public void testLFUCache2() {

        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        assertEquals(1, lfuCache.get(1));
        lfuCache.put(3, 3);
        assertEquals(-1, lfuCache.get(2));
        lfuCache.put(4, 4);
        assertEquals(-1, lfuCache.get(3));
        assertEquals(4, lfuCache.get(4));
        lfuCache.put(5, 5);
    }
}
