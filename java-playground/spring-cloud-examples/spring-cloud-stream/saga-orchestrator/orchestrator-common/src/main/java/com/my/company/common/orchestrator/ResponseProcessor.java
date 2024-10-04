package com.my.company.common.orchestrator;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.Response;
import org.reactivestreams.Publisher;

public interface ResponseProcessor<T extends Response> {

    Publisher<Request> process(T response);

}
