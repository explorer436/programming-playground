package com.example.awssqs.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.awssqs.publisher.SqsMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SQSService {

    private final SqsMessagePublisher sqsMessagePublisher;
    public void putMessageOnQueue(String aValueForMessageAttributeValue1, String aValueForMessageAttributeValue2) {
        sqsMessagePublisher.publishToOutboundQueue(aValueForMessageAttributeValue1, aValueForMessageAttributeValue2);
    }
}
