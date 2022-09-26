package com.example;

public class HelloRunnableFromNewThread implements Runnable {

	@Override
    public void run() {
        System.out.println("Hello from a thread!");
    }   

    public static void main(String args[]) {
    	// You can pass Runnable to create a Thread.
        (new Thread(new HelloRunnableFromNewThread())).start();
        System.out.println("Hello from main");
    }

}  

// Output:
// Hello from main
// Hello from a thread!

// The code in run() is executed after the main() method completes its execution. 