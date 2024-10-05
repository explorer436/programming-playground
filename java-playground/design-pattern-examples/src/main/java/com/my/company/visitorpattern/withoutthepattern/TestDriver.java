package com.my.company.visitorpattern.withoutthepattern;

public class TestDriver {
    public static void main(String[] args) {
        MailClient operaMailClient = new OperaMailClient();
        System.out.println(operaMailClient.configureForMac());
        System.out.println(operaMailClient.configureForWindows());
        MailClient squirrelMailClient = new SquirrelMailClient();
        System.out.println(squirrelMailClient.configureForMac());
        System.out.println(squirrelMailClient.configureForWindows());
    }
}
