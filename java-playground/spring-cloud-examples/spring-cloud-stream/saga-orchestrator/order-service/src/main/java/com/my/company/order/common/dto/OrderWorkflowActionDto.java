package com.my.company.order.common.dto;

import com.my.company.order.common.enums.WorkflowAction;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record OrderWorkflowActionDto(UUID id,
                                     UUID orderId,
                                     WorkflowAction action,
                                     Instant createdAt) {
}
