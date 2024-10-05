package com.my.company.adapterpattern.example3;

public class CsvFormatter implements CsvFormattable {
    @Override
    public String formatCsvText(String text) {
        String formattedText = text.replace(".", ",");
        return formattedText;
    }
}
