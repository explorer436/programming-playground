package com.my.company.utility;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class URLEncoderUtilsTests {

    URLEncoderUtils urlEncoderUtils = new URLEncoderUtils();

    @Test
    public void givenRequestParam_whenUTF8Scheme_thenEncode() throws Exception {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("value 1", "value+1");
        requestParams.put("value@!$2", "value%40%21%242");
        requestParams.put("value%3", "value%253");
        requestParams.put("value,4", "value%2C4");

        Iterator<Map.Entry<String, String>> entrySet_Iterator = requestParams.entrySet().iterator();
        while (entrySet_Iterator.hasNext()) {
            Map.Entry<String, String> new_Map = (Map.Entry<String, String>) entrySet_Iterator.next();
            System.out.println(new_Map.getKey() + " = " + new_Map.getValue());

            String encodedRequestParam = null;
                        try {
                            encodedRequestParam = urlEncoderUtils.encodeValue(new_Map.getKey());
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }

            assertEquals(new_Map.getValue(), encodedRequestParam);
        }
    }

    @Test
    public void givenRequestParam_whenUTF8Scheme_thenDecode() throws Exception {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("value+1", "value 1");
        requestParams.put("value%40%21%242", "value@!$2");
        requestParams.put("value%253", "value%3");
        requestParams.put("value%2C4", "value,4");

        Iterator<Map.Entry<String, String>> entrySet_Iterator = requestParams.entrySet().iterator();
        while (entrySet_Iterator.hasNext()) {
            Map.Entry<String, String> new_Map = (Map.Entry<String, String>) entrySet_Iterator.next();
            System.out.println(new_Map.getKey() + " = " + new_Map.getValue());

            String encodedRequestParam = null;
            try {
                encodedRequestParam = urlEncoderUtils.decodeValue(new_Map.getKey());
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            assertEquals(new_Map.getValue(), encodedRequestParam);
        }
    }
}
