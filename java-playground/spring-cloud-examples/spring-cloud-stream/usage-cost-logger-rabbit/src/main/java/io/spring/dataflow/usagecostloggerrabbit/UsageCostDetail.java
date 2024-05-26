package io.spring.dataflow.usagecostloggerrabbit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class UsageCostDetail {
    private String userId;
    private Double callCost;
    private Double dataCost;
}
