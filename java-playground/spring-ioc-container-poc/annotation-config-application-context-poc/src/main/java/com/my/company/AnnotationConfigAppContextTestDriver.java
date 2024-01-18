package com.my.company;

import com.my.company.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class AnnotationConfigAppContextTestDriver
{
    public static void main(String[] args) {

        System.out.println( "Hello World!" );

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = ctx.getBean(MyService.class);
        myService.doStuff();

            /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.scan("com.acme");
            ctx.refresh();
            MyService myService = ctx.getBean(MyService.class);*/

    }
}
