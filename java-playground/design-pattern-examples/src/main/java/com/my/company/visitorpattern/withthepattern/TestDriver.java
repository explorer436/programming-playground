package com.my.company.visitorpattern.withthepattern;

public class TestDriver {

    private static MacMailClientVisitor macVisitor;
    private static LinuxMailClientVisitor linuxVisitor;
    private static WindowsMailClientVisitor windowsVisitor;
    private static OperaMailClient operaMailClient;
    private static SquirrelMailClient squirrelMailClient;
    private static ZimbraMailClient zimbraMailClient;

    public static void main(String[] args) throws Exception {
        macVisitor = new MacMailClientVisitor();
        linuxVisitor = new LinuxMailClientVisitor();
        windowsVisitor = new WindowsMailClientVisitor();
        operaMailClient = new OperaMailClient();
        squirrelMailClient = new SquirrelMailClient();
        zimbraMailClient = new ZimbraMailClient();

        testOperaMailClient();
        testSquirrelMailClient();
        testZimbraMailClient();
    }

    public static void testOperaMailClient() throws Exception {
        System.out.println("-----Testing Opera Mail Client for different environments-----");
        System.out.println(operaMailClient.accept(macVisitor));
        System.out.println(operaMailClient.accept(linuxVisitor));
        System.out.println(operaMailClient.accept(windowsVisitor));
    }

    public static void testSquirrelMailClient() throws Exception {
        System.out.println("\n-----Testing Squirrel Mail Client for different environments-----");
        System.out.println(squirrelMailClient.accept(macVisitor));
        System.out.println(squirrelMailClient.accept(linuxVisitor));
        System.out.println(squirrelMailClient.accept(windowsVisitor));
    }

    public static void testZimbraMailClient() throws Exception {
        System.out.println("\n-----Testing Zimbra Mail Client for different environments-----");
        System.out.println(zimbraMailClient.accept(macVisitor));
        System.out.println(zimbraMailClient.accept(linuxVisitor));
        System.out.println(zimbraMailClient.accept(windowsVisitor));
    }
}
