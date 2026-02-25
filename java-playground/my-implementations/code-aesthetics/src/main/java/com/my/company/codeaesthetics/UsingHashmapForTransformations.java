package com.my.company.codeaesthetics;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Map;

public class UsingHashmapForTransformations {

    static StopWatch watch = new StopWatch();
    private static final Map<String, String[]> map;

    static {
        // immutable
        map = Map.of("USA", new String[]{"usa-address-line-1", "usa-city", "usa-state", "usa-zip-code"},
                "Canada", new String[]{"canada-address-line-1", "canada-city", "canada-state", "canada-zip-code"});
    }

    public MyAddress transformation_using_if_else(String countryName) {

        watch.reset();
        watch.start();

        MyAddress myAddress;

        if (countryName.equals("USA")) {
            myAddress = new MyAddress("usa-address-line-1", "usa-city", "usa-state", "usa-zip-code");
        } else if (countryName.equals("Canada")) {
            myAddress = new MyAddress("canada-address-line-1", "canada-city", "canada-state", "canada-zip-code");
        } else throw new RuntimeException("Invalid input to function foo");

        watch.stop();
        System.out.println("Transformation using if-else took " + watch.getNanoTime() + " nano seconds.");

        return myAddress;
    }

    public MyAddress transformation_using_map(String countryName) {

        watch.reset();
        watch.start();

        String[] stringArray = map.get(countryName);

        MyAddress myAddress = new MyAddress(stringArray[0], stringArray[1], stringArray[2], stringArray[3]);

        watch.stop();
        System.out.println("Transformation using map took " + watch.getNanoTime() + " nano seconds.");
        return myAddress;
    }


    public record MyAddress (
        String addressLine1,
        String city,
        String state,
        String zipCode){}

}