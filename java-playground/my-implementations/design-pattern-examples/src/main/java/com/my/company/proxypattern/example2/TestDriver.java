package com.my.company.proxypattern.example2;

public class TestDriver {
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("generating reports as a Manager");

        Role accessRole = new Role();
        accessRole.setRole("Manager");

        ReportGenerator proxy = new ReportGeneratorImplProxy(accessRole);
        proxy.displayReportTemplate("Pdf", 150);
        proxy.generateComplexReport("Pdf", 150);
        proxy.generateSensitiveReport();

        System.out.println("");
        System.out.println("generating reports as a non manager");

        accessRole = new Role();
        accessRole.setRole("Not a manager");

        proxy = new ReportGeneratorImplProxy(accessRole);
        proxy.displayReportTemplate("Pdf", 150);
        proxy.generateComplexReport("Pdf", 150);
        proxy.generateSensitiveReport();
    }
}
