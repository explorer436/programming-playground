package com.my.company;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.my.company")
public class AppConfig  {
    // ...
}
