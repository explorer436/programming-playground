package com.my.company;

import com.my.company.extendthreadclass.MyThread;
import com.my.company.implementrunnableinterface.MyRunnable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("starting with thread " + Thread.currentThread().getName());

        createThread1_withNoCode();
        createThread1_usingAnonymousClass();
        createThread1_usingLambdaExpression();
        createThread1_usingAnonymousClass_withCustomThreadName();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyThread myThread = ctx.getBean(MyThread.class);
        myThread.start();

        MyRunnable myRunnable = ctx.getBean(MyRunnable.class);
        myRunnable.run();

        Runnable myRunnable4 =
                new Runnable() {
                    public void run() {
                        System.out.println("myRunnable4 - " + Thread.currentThread().getName() + " - Running");
                    }
                };
        myRunnable4.run(); // Notice that this does not really create a new thread
        new Thread(myRunnable4).start(); // This creates a new thread and executes the code in the run() method

        Runnable myRunnable5 =
                () -> System.out.println("myRunnable5 - " + Thread.currentThread().getName() + " - Running");
        myRunnable5.run(); // Notice that this does not really create a new thread
        new Thread(myRunnable5).start(); // This creates a new thread and executes the code in the run() method

        Runnable myRunnable6 =
                () -> System.out.println("Runnable6 - " + Thread.currentThread().getName() + " - Running");
        Thread thread6 = new Thread(myRunnable6, "myRunnable6-123");
        thread6.start(); // This creates a new thread and executes the code in the run() method

        anotherMethod();
    }

    private static void createThread1_withNoCode() {

        /**
         * This example doesn't specify any code for the thread to execute.
         * So, the thread will stop again right away after it is started.
         */

        Thread thread = new Thread();
        thread.start();
    }

    private static void createThread1_usingLambdaExpression() {
        Thread thread = new Thread(() ->
                System.out.println("createThread1_usingLambdaExpression - " + Thread.currentThread().getName() + " - Running"));

        thread.start();
    }

    private static void createThread1_usingAnonymousClass() {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("createThread1_usingAnonymousClass - " + Thread.currentThread().getName() + " - Running");
            }
        };

        thread.start();
    }

    private static void createThread1_usingAnonymousClass_withCustomThreadName() {
        Thread thread = new Thread("MyThreadWithCustomName123") {
            public void run() {
                // System.out.println("run by: " + getName());
                System.out.println("createThread1_usingAnonymousClass_withCustomThreadName - " + Thread.currentThread().getName() + " - Running");
            }
        };

        thread.start();
    }

    public static void anotherMethod() {

        // This line runs on the thread of the main() method
        System.out.println(">>> anotherMethod() - " + Thread.currentThread().getName());

        // Note that all the 10 new threads may not run or complete in a proper sequence because they are running in parallel.
        for (int i = 0; i < 10; i++) {
            new Thread("LoopCounter" + i) {
                public void run() {
                    System.out.println("Thread with the name :" + getName() + " is running");
                }
            }.start();
        }
    }
}
