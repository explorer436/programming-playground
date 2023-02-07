package com.example.springcloudawsdynamodb.entities.converter;

import com.example.springcloudawsdynamodb.entities.SubObject;
import lombok.SneakyThrows;

public class SubObjectConverter extends JsonConverter<SubObject> {
    @Override
    @SneakyThrows
    public SubObject unconvert(String s) {
        return objectMapper.readValue(s, SubObject.class);
    }
}
