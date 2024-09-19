package com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto;

public record PhysicalDelivery(int productId,
                               String street,
                               String city,
                               String country) {
}
