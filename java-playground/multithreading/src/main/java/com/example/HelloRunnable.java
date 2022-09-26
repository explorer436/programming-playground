package com.example;

public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }   

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
        System.out.println("Hello from main");
    }

}  

// Output:
// Hello from main
// Hello from a thread!

// The code in run() is executed after the main() method completes its execution. 