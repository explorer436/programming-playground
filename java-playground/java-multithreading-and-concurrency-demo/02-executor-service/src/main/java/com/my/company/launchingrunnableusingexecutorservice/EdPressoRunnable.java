package com.my.company.launchingrunnableusingexecutorservice;

public class EdPressoRunnable implements Runnable {

    public void run() {
    	System.out.println("Thread name: " + Thread.currentThread().getName() + ", Thread id: "
				+ Thread.currentThread().getId() + ", Output for the part running inside the thread ");
    }
}

// Output
// Thread name: main, Thread id: 1, Output for code outside the thread
// Thread name: Thread-0, Thread id: 14, Output for the part running inside the thread 

// The code in run() is executed after the main() method completes its execution. 