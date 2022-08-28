package io.spring.dataflow.sample.usagecostprocessorkafka;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UsageDetail {
    private String userId;
    private Integer data;
    private Integer duration;
}
