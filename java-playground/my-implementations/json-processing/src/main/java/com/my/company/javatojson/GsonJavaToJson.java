package com.my.company.javatojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.my.company.javatojson.gsonbuilderadapters.LocalDateTimeTypeAdapter;
import com.my.company.javatojson.gsonbuilderadapters.OffsetDateTimeTypeAdapter;
import com.my.company.model.Employee;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonJavaToJson {

    public String javaObjectToJsonString(List<String> l) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(l);
    }

    public String javaObjectToJsonString(Employee e) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // JsonIO Failed making field 'java.time.LocalDateTime#date' accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.
        // JsonIO Failed making field 'java.time.OffsetDateTime#dateTime' accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter());
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter());

        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(e);
    }

    public JsonObject mapWithStringValuesToJsonObject() {
        JsonObject jsonObject = new JsonObject();

        Map<String, String> sampleMap = new HashMap<String, String>();
        sampleMap.put("John Smith", "521-1234");
        sampleMap.put("Sam Doe", "521-5030");
        sampleMap.put("Sandra Dee", "521-9655");

        for (Map.Entry<String, String> set : sampleMap.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            jsonObject.addProperty(set.getKey(), set.getValue());
        }

        return jsonObject;
    }
}
