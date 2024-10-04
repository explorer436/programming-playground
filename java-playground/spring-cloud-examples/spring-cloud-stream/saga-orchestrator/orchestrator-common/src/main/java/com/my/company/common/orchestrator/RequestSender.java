package com.my.company.common.orchestrator;

import com.my.company.common.messages.Request;
import org.reactivestreams.Publisher;

import java.util.UUID;

public interface RequestSender {

    /*
       Don't want to specify whether it is a Mono or a Flux - it can be either.
       We can make the parameter generic instead of a UUID - another option.
     */
    Publisher<Request> send(UUID id);

}
