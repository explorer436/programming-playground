package com.my.company;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.my.company")
public class AppConfig  {
    // ...
    // The purpose of this class is to specify the base package for component scan
}
