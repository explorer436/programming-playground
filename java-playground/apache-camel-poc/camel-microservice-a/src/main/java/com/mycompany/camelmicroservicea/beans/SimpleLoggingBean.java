package com.mycompany.camelmicroservicea.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleLoggingBean {
    public void process(String msg) {
        log.info("SimpleLoggingBean :: msg is : {}", msg);
    }
}
