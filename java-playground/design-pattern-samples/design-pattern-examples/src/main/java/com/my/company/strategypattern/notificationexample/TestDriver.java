package com.my.company.strategypattern.notificationexample;

import com.my.company.strategypattern.notificationexample.factory.StrategyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.my.company.AppConfig;

public class TestDriver {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        StrategyFactory strategyFactory = ctx.getBean(StrategyFactory.class);

        strategyFactory.execute(NotificationType.EMAIL);
        strategyFactory.execute(NotificationType.PUSH_NOTIFICATION);
        strategyFactory.execute(NotificationType.SMS);
    }
}
