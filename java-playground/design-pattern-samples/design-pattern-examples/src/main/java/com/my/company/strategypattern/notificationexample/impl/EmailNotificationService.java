package com.my.company.strategypattern.notificationexample.impl;

import com.my.company.strategypattern.notificationexample.NotificationService;
import com.my.company.strategypattern.notificationexample.NotificationType;
import org.springframework.stereotype.Service;

@Service(NotificationType.EMAIL)
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Sending email");
    }
}
