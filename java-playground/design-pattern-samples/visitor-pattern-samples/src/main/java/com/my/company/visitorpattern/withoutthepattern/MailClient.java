package com.my.company.visitorpattern.withoutthepattern;

public interface MailClient {
    void sendMail(String[] mailInfo);

    void receiveMail(String[] mailInfo);

    boolean configureForMac();

    boolean configureForWindows();
}
