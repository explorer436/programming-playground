package com.example.spring_conditional_autoconfiguration.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="friendly.enabled",
        havingValue = "false",
        matchIfMissing = true)
public class HostileGreeting implements Greeting {

    @Override
    public String sayHello() {
        return "Go away.";
    }
}
