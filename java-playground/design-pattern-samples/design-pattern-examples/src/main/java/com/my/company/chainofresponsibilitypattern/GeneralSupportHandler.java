package com.my.company.chainofresponsibilitypattern;

public class GeneralSupportHandler extends AbstractSupportHandler {

    public GeneralSupportHandler(int level) {
        this.level = level;
    }

    @Override
    protected void handleRequest(String message) {
        System.out.println("GeneralSupportHandler: Processing request. " + message);

    }
}
