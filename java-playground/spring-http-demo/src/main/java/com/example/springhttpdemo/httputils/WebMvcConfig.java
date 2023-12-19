package com.example.springhttpdemo.httputils;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final MyCustomHandlerInterceptor myCustomHandlerInterceptor;

    // In properties file, auth.exclude.urls=/**/health,/**/api-docs/**,/**swagger-ui/**
    // @Value("#{'${auth.exclude.urls}'.split(',')}")
    // private List<String> excludeEndpoints;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myCustomHandlerInterceptor);

        // registry.addInterceptor(myCustomHandlerInterceptor).excludePathPatterns(excludeEndpoints);
    }

}