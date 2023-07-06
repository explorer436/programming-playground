package com.my.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        mergeTwoJsonStringsWithoutKnowingTheirTypes();

        printArrayListAsJson();
    }

    /**
     * Output:
     *
     * Hello World!
     * JSON String after inserting additional property: {
     *   "name": "myName",
     *   "java": true,
     *   "id": "115",
     *   "title": "Sample Konfabulator Widget"
     * }
     * abc: [
     *   "first",
     *   "second"
     * ]
     */

    private static void mergeTwoJsonStringsWithoutKnowingTheirTypes() {
        // String str1 = "{title: Sample Konfabulator Widget,name: main_window,width: 500,height: 500}";
        // String str2 = "{name: sun1}";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "{ \"name\": \"myName\", \"java\": true }";
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        jsonObject.addProperty("id", "115");
        jsonObject.addProperty("title", "Sample Konfabulator Widget");
        String jsonStr = gson.toJson(jsonObject);
        System.out.println("JSON String after inserting additional property: " + jsonStr);
    }

    private static void printArrayListAsJson() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<String> l = new ArrayList<>();
        l.add("first");
        l.add("second");

        String abc = gson.toJson(l);
        System.out.println("abc: " + abc);
    }
}
