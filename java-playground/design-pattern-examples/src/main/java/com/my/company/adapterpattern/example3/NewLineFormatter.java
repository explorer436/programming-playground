package com.my.company.adapterpattern.example3;

public class NewLineFormatter implements TextFormattable {
    @Override
    public String formatText(String text) {
        return text.replace(".", "\n");
    }
}
