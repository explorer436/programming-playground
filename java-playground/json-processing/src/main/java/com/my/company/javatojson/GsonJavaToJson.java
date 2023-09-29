package com.my.company.javatojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.my.company.javatojson.adapters.LocalDateTimeTypeAdapter;
import com.my.company.javatojson.adapters.OffsetDateTimeTypeAdapter;
import com.my.company.model.Employee;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class GsonJavaToJson {

    public String javaToJson(List<String> l) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String abc = gson.toJson(l);
        System.out.println("abc: " + abc);

        return abc;
    }

    public String javaToJson(Employee e) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // JsonIO Failed making field 'java.time.LocalDateTime#date' accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.
        // JsonIO Failed making field 'java.time.OffsetDateTime#dateTime' accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter());
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter());

        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(e);
    }
}
