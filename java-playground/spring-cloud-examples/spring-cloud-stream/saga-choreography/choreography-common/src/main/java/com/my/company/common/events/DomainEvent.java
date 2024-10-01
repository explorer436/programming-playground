package com.my.company.common.events;

import java.time.Instant;

public interface DomainEvent {

    Instant createdAt();

}
