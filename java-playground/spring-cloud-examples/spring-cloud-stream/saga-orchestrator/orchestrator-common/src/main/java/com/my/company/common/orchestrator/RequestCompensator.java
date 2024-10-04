package com.my.company.common.orchestrator;

import com.my.company.common.messages.Request;
import org.reactivestreams.Publisher;

import java.util.UUID;

public interface RequestCompensator {

    Publisher<Request> compensate(UUID id);

}
