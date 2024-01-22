package com.my.company;

public class WorkerThread extends Thread {

    public WorkerThread() {
        // When false, (i.e. when it's a non daemon thread),
        // the WorkerThread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the WorkerThread terminates when the main
        // thread or/and user defined thread(non daemon) terminates.
        setDaemon(true);
    }

    public void run() {
        int count = 0;

        // an infinite loop
        while (true) {
            System.out.println("Hello from WorkerThread " + count++);

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                // handle exception here
            }
        }
    }
}

