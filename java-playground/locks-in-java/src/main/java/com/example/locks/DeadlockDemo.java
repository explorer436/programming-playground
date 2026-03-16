package com.example.locks;

import com.example.locks.impl.ReentrantLockManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            acquireLocks(lock1, lock2, "Thread-1");
        });

        Thread t2 = new Thread(() -> {
            acquireLocks(lock2, lock1, "Thread-2");
        });

        System.out.println("Starting Deadlock Demo...");
        System.out.println("Thread-1 will try to lock (lock1, then lock2)");
        System.out.println("Thread-2 will try to lock (lock2, then lock1)");
        
        t1.start();
        t2.start();

        // Monitor thread
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("[Monitor] Checking for deadlock... Threads are likely stuck.");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }

    private static void acquireLocks(Lock firstLock, Lock secondLock, String threadName) {
        firstLock.lock();
        try {
            System.out.println(threadName + ": Acquired first lock. Waiting for second lock...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            
            secondLock.lock();
            try {
                System.out.println(threadName + ": Acquired both locks!");
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }
}
