package com.my.company.visitorpattern.withthepattern;

public interface MailClient {
    void sendMail(String[] mailInfo);

    void receiveMail(String[] mailInfo);

    boolean accept(MailClientVisitor visitor);
}
