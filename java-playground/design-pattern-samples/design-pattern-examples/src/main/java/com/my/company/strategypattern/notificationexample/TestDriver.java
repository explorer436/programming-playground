package com.my.company.strategypattern.notificationexample;

import com.my.company.strategypattern.notificationexample.factory.NotificationFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.my.company.AppConfig;

public class TestDriver {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        NotificationFactory notificationFactory = ctx.getBean(NotificationFactory.class);

        notificationFactory.execute(NotificationType.EMAIL);
        notificationFactory.execute(NotificationType.PUSH_NOTIFICATION);
        notificationFactory.execute(NotificationType.SMS);
    }
}
