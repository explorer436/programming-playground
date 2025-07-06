package com.my.company.lru_cache_implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLRUCache {

    @Test
    public void testLRUCache() {
        int[] pageNumberArray = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};

        int cacheSize = 3;

        LRUCache lruCache = new LRUCache(cacheSize);

        int hitCount = 0;
        int faultCount = 0;
        for (int key : pageNumberArray) {
            if (-1 != lruCache.get(key)) {
                hitCount++;
            } else {
                faultCount++;
                lruCache.put(key, key);
            }
        }

        assertEquals(2, hitCount);
        assertEquals(10, faultCount);
    }
}
