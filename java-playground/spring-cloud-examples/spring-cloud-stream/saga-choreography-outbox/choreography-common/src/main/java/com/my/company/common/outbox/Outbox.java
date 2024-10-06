package com.my.company.common.outbox;

import com.my.company.common.events.DomainEvent;
import lombok.Builder;

@Builder
public record Outbox<T extends DomainEvent>(Long correlationId,
                                            T event) {
}
