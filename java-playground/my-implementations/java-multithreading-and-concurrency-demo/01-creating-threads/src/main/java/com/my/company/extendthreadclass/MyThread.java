package com.my.company.extendthreadclass;

import org.springframework.stereotype.Service;

@Service
public class MyThread extends Thread {

    /**
     * The start() call will return as soon as the thread is started.
     * It will not wait until the run() method is done.
     * The run() method will execute as if executed by a different CPU.
     * When the run() method executes it will print out the text "MyThread2 running".
     */

    public void run(){
        System.out.println("MyThread.run() - " + Thread.currentThread().getName() + " - Running");
    }
}
