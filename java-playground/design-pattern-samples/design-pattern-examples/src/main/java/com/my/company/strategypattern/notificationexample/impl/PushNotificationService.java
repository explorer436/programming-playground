package com.my.company.strategypattern.notificationexample.impl;

import com.my.company.strategypattern.notificationexample.NotificationService;
import com.my.company.strategypattern.notificationexample.NotificationType;
import org.springframework.stereotype.Service;

@Service(NotificationType.PUSH_NOTIFICATION)
public class PushNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Sending push notification");
    }
}
