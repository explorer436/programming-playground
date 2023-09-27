package com.example.springcloudawsdynamodb.entities.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;

public abstract class JsonConverter<T> implements DynamoDBTypeConverter<String, T> {

    protected final ObjectMapper objectMapper = new ObjectMapper();
    {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @SneakyThrows
    @Override
    public String convert(T objectsThatNeedToBeInsertedInTable) {
        return objectMapper.writeValueAsString(objectsThatNeedToBeInsertedInTable);
    }

    @Override
    public abstract T unconvert(String s);
}
