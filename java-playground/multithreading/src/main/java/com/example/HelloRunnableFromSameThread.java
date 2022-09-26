package com.example;

public class HelloRunnableFromSameThread implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }   

    public static void main(String args[]) {
    	// You can pass Runnable to create a Thread.
        (new HelloRunnableFromSameThread()).run();
        System.out.println("Hello from main");
    }

}  

// Output:
// Hello from a thread!
// Hello from main

// The code in run() is executed in the same thread where main() is running. 