package com.my.company.common.orchestrator;

public interface WorkflowChain {

    void setPreviousStep(RequestCompensator previousStep);

    void setNextStep(RequestSender nextStep);

}
