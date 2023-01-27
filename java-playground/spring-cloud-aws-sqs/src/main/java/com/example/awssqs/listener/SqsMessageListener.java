package com.example.awssqs.listener;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.Visibility;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SqsMessageListener {

    @SqsListener(value = "${standard.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.NO_REDRIVE)
    public void listener(@Payload String payloadString,
                         @Header("a-message-attribute-1") String aMessageAttribute1,
                         @Header("a-message-attribute-2") String aMessageAttribute2,
                         Visibility visibility) throws Exception {
        log.info(">>> listener picked up message from the queue at " + java.time.LocalTime.now());

        log.info("payloadString: " + payloadString);
        log.info("aMessageAttribute1: " + aMessageAttribute1);
        log.info("aMessageAttribute2: " + aMessageAttribute2);

        if (StringUtils.equalsIgnoreCase("happy", aMessageAttribute1)) {
            handleHappyScenarios();
        }

        if (StringUtils.equalsIgnoreCase("fail", aMessageAttribute1)) {
            handleFailureScenarios(visibility);
        }

        log.info("<<< listener()");
    }

    private void handleHappyScenarios() {

    }

    private void handleFailureScenarios(Visibility visibility) throws Exception {
        visibility.extend(60).get();
        throw new Exception("Exception message");
    }
}
