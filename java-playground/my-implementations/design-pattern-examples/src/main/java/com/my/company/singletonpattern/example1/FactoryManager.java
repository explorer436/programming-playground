package com.my.company.singletonpattern.example1;

public class FactoryManager {
    private static FactoryManager instance = null;

    private FactoryManager() {
    }

    public static FactoryManager getInstance() {
        if (instance == null) {
            instance = new FactoryManager();
        }
        return instance;
    }

    private static int numTracks = 5;

    public static void startTracks() {
        for (int i = 0; i < numTracks; ++i) {
            Track t = new Track();
            t.start(i);
        }
    }
}
