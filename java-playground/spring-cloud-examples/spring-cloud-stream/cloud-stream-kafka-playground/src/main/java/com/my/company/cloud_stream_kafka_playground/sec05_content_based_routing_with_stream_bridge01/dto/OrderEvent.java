package com.my.company.cloud_stream_kafka_playground.sec05_content_based_routing_with_stream_bridge01.dto;

public record OrderEvent(int customerId,
                         int productId,
                         OrderType orderType) {
}
