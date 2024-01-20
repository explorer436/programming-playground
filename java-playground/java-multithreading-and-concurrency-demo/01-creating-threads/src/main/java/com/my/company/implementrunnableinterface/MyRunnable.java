package com.my.company.implementrunnableinterface;

import org.springframework.stereotype.Service;

@Service
public class MyRunnable implements Runnable {

    /**
     * When the thread is started it will call the run() method of the MyRunnable instance instead of executing it's own run() method.
     *
     * After printing that text, the run() method exits, and the thread running the run() method will stop.
     */

    public void run(){
        System.out.println("MyRunnable.run() - " + Thread.currentThread().getName() + " - Running");
    }
}