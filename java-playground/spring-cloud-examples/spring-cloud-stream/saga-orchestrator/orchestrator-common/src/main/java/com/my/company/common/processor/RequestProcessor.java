package com.my.company.common.processor;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.Response;
import reactor.core.publisher.Mono;

public interface RequestProcessor<T extends Request, R extends Response> {

    Mono<R> process(T request);

}
