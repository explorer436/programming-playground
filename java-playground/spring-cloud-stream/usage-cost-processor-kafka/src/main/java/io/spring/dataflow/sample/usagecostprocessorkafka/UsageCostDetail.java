package io.spring.dataflow.sample.usagecostprocessorkafka;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UsageCostDetail {
    private String userId;
    private Double callCost;
    private Double dataCost;
}
