package com.my.company.cloud_stream_kafka_playground.sec12_native_encoding_and_decoding01.dto;

public record Phone(int number) implements ContactMethod {
    @Override
    public void contact() {
        System.out.println("contacting via " + number);
    }
}
