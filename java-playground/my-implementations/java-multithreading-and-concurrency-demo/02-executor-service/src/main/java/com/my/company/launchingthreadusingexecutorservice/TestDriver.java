package com.my.company.launchingthreadusingexecutorservice;

import com.my.company.AppConfig;
import com.my.company.launchingcallableusingexecutorservice.EdPressoCallable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDriver {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ImplementThreadByExtendingThreadClass implementThreadByExtendingThreadClass = ctx.getBean(ImplementThreadByExtendingThreadClass.class);

        // first method of running a thread of this type

        implementThreadByExtendingThreadClass.setMessage("SimpleThread executed using Thread");
        Thread thread = implementThreadByExtendingThreadClass;
        thread.start();
        thread.join();

        // second method of running a thread of this type

        implementThreadByExtendingThreadClass.setMessage("SimpleThread executed using ExecutorService");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(implementThreadByExtendingThreadClass).get();
    }
}
