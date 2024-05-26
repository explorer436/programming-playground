package com.example.awssqs.publisher;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class SqsMessagePublisher {

    @Value("${standard.queue.name}")
    private String standardQueueName;

    private final AmazonSQSAsync amazonSQSAsync;

    public void publishToOutboundQueue(String aValueForMessageAttributeValue1, String aValueForMessageAttributeValue2) {
        log.info(">>> publishToOutboundQueue()");

        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        MessageAttributeValue messageAttributeValue1 = new MessageAttributeValue()
                .withDataType("String")
                .withStringValue(aValueForMessageAttributeValue1);
        MessageAttributeValue messageAttributeValue2 = new MessageAttributeValue()
                .withDataType("String")
                .withStringValue(aValueForMessageAttributeValue2);
        messageAttributes.put("a-message-attribute-1", messageAttributeValue1);
        messageAttributes.put("a-message-attribute-2", messageAttributeValue1);

        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withMessageBody("a-message-body")
                .withMessageAttributes(messageAttributes)
                .withQueueUrl(standardQueueName);

        log.info("sendMessageRequest: " + sendMessageRequest.toString());

        amazonSQSAsync.sendMessage(sendMessageRequest);
        log.info("<<< publishToOutboundQueue()");
    }

    // Send multiple messages to the queue
    public void publishBatchRequestsToOutboundQueue() {
        log.info(">>> publishToOutboundQueue()");

        SendMessageBatchRequest send_batch_request = new SendMessageBatchRequest()
                .withQueueUrl(standardQueueName)
                .withEntries(
                        new SendMessageBatchRequestEntry(
                                "msg_1", "Hello from message 1"),
                        new SendMessageBatchRequestEntry(
                                "msg_2", "Hello from message 2")
                                .withDelaySeconds(10));

        amazonSQSAsync.sendMessageBatch(send_batch_request);
        log.info("<<< publishToOutboundQueue()");
    }
}
