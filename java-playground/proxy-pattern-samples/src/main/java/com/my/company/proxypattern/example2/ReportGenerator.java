package com.my.company.proxypattern.example2;

public interface ReportGenerator {
    void displayReportTemplate(String reportFormat, int reportEntries);

    void generateComplexReport(String reportFormat, int reportEntries);

    void generateSensitiveReport();
}
