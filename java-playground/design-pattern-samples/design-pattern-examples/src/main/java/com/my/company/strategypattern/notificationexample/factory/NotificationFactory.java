package com.my.company.strategypattern.notificationexample.factory;

import com.my.company.strategypattern.notificationexample.NotificationService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationFactory {

    private final Map<String, NotificationService> notificationServiceMap;

    /**
     * Uses constructor-autowiring to create a new NotificationFactory instance
     * with the provided map of NotificationService instances.
     *
     * @param notificationServices a map of NotificationService instances
     */
    public NotificationFactory(Map<String, NotificationService> notificationServices) {
        this.notificationServiceMap = notificationServices;
    }

    public NotificationService getNotificationService(String notificationType) {
        NotificationService notificationService = notificationServiceMap.get(notificationType);
        if (notificationService == null) {
            throw new RuntimeException("Unsupported notification type");
        }

        return notificationService;
    }

    public void execute(String notificationType) {
        NotificationService notificationService = getNotificationService(notificationType);
        notificationService.sendNotification();
    }
}
