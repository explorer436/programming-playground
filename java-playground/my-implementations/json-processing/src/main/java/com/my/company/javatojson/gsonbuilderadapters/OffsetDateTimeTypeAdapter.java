package com.my.company.javatojson.gsonbuilderadapters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeTypeAdapter implements JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Override
    public JsonElement serialize(final OffsetDateTime date, final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        return new JsonPrimitive(date.format(formatter));
    }

    @Override
    public OffsetDateTime deserialize(final JsonElement json, final Type typeOfT,
                                 final JsonDeserializationContext context) {
        return OffsetDateTime.parse(json.getAsString(), formatter);
    }
}