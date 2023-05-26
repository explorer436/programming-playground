package com.my.company.singletonpattern.doublechecklocking;

public class Thread2 implements Runnable {
    @Override
    public void run() {
        SingletonMultiThreaded singletonMultiThreaded = SingletonMultiThreaded.getInstance();
        System.out.print(singletonMultiThreaded.hashCode() + " ");
    }
}
