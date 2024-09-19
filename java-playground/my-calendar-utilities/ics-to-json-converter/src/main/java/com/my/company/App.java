package com.my.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;
import org.mnode.ical4j.serializer.JCalSerializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/*
    I did not end up using this.
    It was easier to do this using javascript.
 */
public class App {

    public static void main(String[] args) throws ParserException, IOException {
        System.out.println("Hello World!");

        parseIcsFile();
    }

    private static void parseIcsFile() throws IOException, ParserException {
        FileInputStream fin = new FileInputStream("fullpath/fromEmacs.ics");
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = builder.build(fin);

        // System.out.println("calendar.toString(): " + calendar.toString());

        writeOutputFile(calendar);
    }

    /*
        This part did not work.
        It kept throwing the exception:

        Exception in thread "main" com.fasterxml.jackson.databind.JsonMappingException: Text '-PT1M' could not be parsed at index 1
        at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._wrapAsIOE(DefaultSerializerProvider.java:509)
        at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:482)
        at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319)
        at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4624)
        at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3869)
        at com.my.company.App.writeOutputFile(App.java:48)
        at com.my.company.App.parseIcsFile(App.java:30)
        at com.my.company.App.main(App.java:20)
    Caused by: java.time.format.DateTimeParseException: Text '-PT1M' could not be parsed at index 1
        at java.base/java.time.format.DateTimeFormatter.parseResolved0(DateTimeFormatter.java:2108)
        at java.base/java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:1936)
        at org.mnode.ical4j.serializer.JCalEncoder.lambda$static$1(JCalEncoder.java:20)
        at org.mnode.ical4j.serializer.JCalEncoder.encode(JCalEncoder.java:41)
        at org.mnode.ical4j.serializer.JCalSerializer.buildPropertyArray(JCalSerializer.java:89)
        at org.mnode.ical4j.serializer.JCalSerializer.buildComponentArray(JCalSerializer.java:60)
        at org.mnode.ical4j.serializer.JCalSerializer.buildComponentArray(JCalSerializer.java:67)
        at org.mnode.ical4j.serializer.JCalSerializer.buildVCalendar(JCalSerializer.java:45)
        at org.mnode.ical4j.serializer.JCalSerializer.serialize(JCalSerializer.java:28)
        at org.mnode.ical4j.serializer.JCalSerializer.serialize(JCalSerializer.java:20)
        at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480)
     */
    private static void writeOutputFile(Calendar calendar) throws IOException {

        for (CalendarComponent component : calendar.getComponents()) {
            List<Property> propertyList = component.getProperties();
            for (Property prop : propertyList) {
                String propName = prop.getName();
                System.out.println("propName: " + propName);
            }
        }

        SimpleModule module = new SimpleModule();
        module.addSerializer(Calendar.class, new JCalSerializer(Calendar.class));
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        String serialized = mapper.writeValueAsString(calendar);

        System.out.println("serialized: " + serialized);

    }
}
