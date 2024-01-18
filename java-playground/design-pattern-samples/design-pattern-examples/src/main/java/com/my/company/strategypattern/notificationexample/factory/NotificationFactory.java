package com.my.company.strategypattern.notificationexample.factory;

import com.my.company.strategypattern.notificationexample.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificationFactory {

    /**
     * Since each strategy (in impl directory) is marked as a Service with @Service annotation, we can get all the concrete implementations of NotificationService interface by Autowiring NotificationService.
     * This will pick all the implementations of NotificationService in a Map, by setting each implementation against the provided Bean name in the @Service annotation.
     * Uses constructor-autowiring to create a new NotificationFactory instance with the provided map of NotificationService instances.
     */

    private final Map<String, NotificationService> notificationServiceMap;

    private NotificationService getNotificationService(String notificationType) {
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
