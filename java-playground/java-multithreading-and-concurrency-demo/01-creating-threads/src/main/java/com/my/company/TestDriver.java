package com.my.company;

import com.my.company.extendthreadclass.MyThread2;
import com.my.company.implementrunnableinterface.MyRunnable3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDriver
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        createThread1_withNoCode();
        createThread1_usingAnonymousClass();
        createThread1_usingLambdaExpression();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyThread2 myThread2 = ctx.getBean(MyThread2.class);
        myThread2.start();

        MyRunnable3 myRunnable3 = ctx.getBean(MyRunnable3.class);
        myRunnable3.run();

        Runnable myRunnable4 =
                new Runnable(){
                    public void run(){
                        System.out.println("Runnable4 running");
                    }
                };
        myRunnable4.run();

        Runnable myRunnable5 =
                () -> System.out.println("Runnable5 running");
        myRunnable5.run();
    }

    private static void createThread1_withNoCode() {

        /**
         * This example doesn't specify any code for the thread to execute.
         * So, the thread will stop again right away after it is started.
         */

        Thread thread = new Thread();
        thread.start();
    }

    private static void createThread1_usingAnonymousClass() {
        Thread thread = new Thread(() -> System.out.println("Thread1 Running"));

        thread.start();
    }

    private static void createThread1_usingLambdaExpression() {
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread1 Running");
            }
        };

        thread.start();
    }


}
