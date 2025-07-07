package com.my.company.jsontojava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.model.ColorData;

public class ObjectMapperReadValue {
    public String readOneField() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ColorData colorData = objectMapper.readValue(json, new TypeReference<ColorData>() {
        });
        return colorData.getColor();
    }

    public ColorData readEntireObject() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ColorData colorData = objectMapper.readValue(json, new TypeReference<ColorData>() {
        });
        return colorData;
    }
}
