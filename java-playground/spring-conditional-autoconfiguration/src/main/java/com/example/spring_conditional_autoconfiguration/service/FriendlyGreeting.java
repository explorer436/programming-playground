package com.example.spring_conditional_autoconfiguration.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="friendly.enabled",
        havingValue = "true",
        matchIfMissing = false)
public class FriendlyGreeting implements Greeting {
    @Override
    public String sayHello() {
        return "Hello, there";
    }
}
