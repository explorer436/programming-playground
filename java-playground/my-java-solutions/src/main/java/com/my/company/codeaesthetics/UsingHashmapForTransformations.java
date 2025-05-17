package com.my.company.codeaesthetics;

import java.util.Map;

class UsingHashmapForTransformations {

    private static final Map<String, String[]> map;
    static{
        // immutable
        map = Map.of("USA", new String[]{"usa-address-line-1", "usa-city", "usa-state", "usa-zip-code"},
                "Canada", new String[]{"canada-address-line-1", "canada-city", "canada-state", "canada-zip-code"});
    }

    public static void main(String[] args) {
        System.out.println(transformation_using_if_else("USA"));
        System.out.println(transformation_using_if_else("Canada"));

        System.out.println(transformation_using_map("USA"));
        System.out.println(transformation_using_map("Canada"));
    }

    private static MyAddress transformation_using_if_else(String countryName){

        MyAddress myAddress = new MyAddress();

        if(countryName.equals("USA")) {
            myAddress.addressLine1 = "usa-address-line-1";
            myAddress.city = "usa-city";
            myAddress.state = "usa-state";
            myAddress.zipCode = "usa-zip-code";
            return myAddress;
        }
        else if(countryName.equals("Canada")) {
            myAddress.addressLine1 = "canada-address-line-1";
            myAddress.city = "canada-city";
            myAddress.state = "canada-state";
            myAddress.zipCode = "canada-zip-code";
            return myAddress;
        }
        else throw new RuntimeException("Invalid input to function foo");
    }

    private static MyAddress transformation_using_map(String countryName){

        String[] stringArray = map.get(countryName);

        MyAddress myAddress = new MyAddress();
        myAddress.addressLine1 = stringArray[0];
        myAddress.city = stringArray[1];
        myAddress.state = stringArray[2];
        myAddress.zipCode = stringArray[3];

        return myAddress;
    }

    static class MyAddress {
        private String addressLine1;
        private String city;
        private String state;
        private String zipCode;

        @Override
        public String toString() {
            return "MyAddress{" +
                    "addressLine1='" + addressLine1 + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    '}';
        }
    }
}