package com.my.company.javatojson.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OffsetDateTimeDeserializer implements JsonDeserializer<OffsetDateTime> {
    @Override
    public OffsetDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return OffsetDateTime.parse(json.getAsString(),
                DateTimeFormatter.ISO_OFFSET_DATE_TIME.withLocale(Locale.ENGLISH));
    }
}