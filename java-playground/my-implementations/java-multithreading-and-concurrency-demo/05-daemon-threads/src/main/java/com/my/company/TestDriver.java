package com.my.company;

public class TestDriver {
    public static void main(String a[]){

        System.out.println("starting main...");

        // Kicking off a daemon thread here.
        new WorkerThread().start();


        // Creating and kicking off another daemon thread here.
        SampleDaemonThread dt = new SampleDaemonThread();
        // We can set daemon constrain here also
        dt.setDaemon(true);
        dt.start();

        // Delay here - The while loop in WorkerThread will still be running because it is an infinite loop.
        try {
            Thread.sleep(12500);
        } catch (InterruptedException e) {
            // handle here exception
        }
        // After this delay, the main thread ends.
        // So, WorkerThread will be terminated because it is a daemon thread

        System.out.println("Main Thread ending") ;
    }
}
