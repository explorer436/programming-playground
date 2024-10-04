package com.my.company.common.orchestrator;

import com.my.company.common.messages.Request;
import com.my.company.common.messages.Response;
import org.reactivestreams.Publisher;

public interface WorkflowOrchestrator {

    Publisher<Request> orchestrate(Response response);

}
