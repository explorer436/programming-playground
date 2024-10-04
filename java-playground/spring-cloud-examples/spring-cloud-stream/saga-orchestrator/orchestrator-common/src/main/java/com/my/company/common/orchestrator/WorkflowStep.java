package com.my.company.common.orchestrator;

import com.my.company.common.messages.Response;

public interface WorkflowStep<T extends Response> extends
                                                        RequestSender,
                                                        RequestCompensator,
                                                        ResponseProcessor<T>,
                                                        WorkflowChain {


}
