package com.my.company.jackson.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.jackson.objectmapper.model.ColorData;

public class ObjectMapperReadValue {
    public String readValue() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ColorData colorData = objectMapper.readValue(json, new TypeReference<ColorData>() {
        });
        return colorData.getColor();
    }
}
