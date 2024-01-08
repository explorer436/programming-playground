package com.example.awss3.service;

public enum S3SubDirectory {
    ATEMPORARYDIRECTORY1("a-temporary-directory-1"),
    ATEMPORARYDIRECTORY2("a-temporary-directory-2");;

    private String value;

    S3SubDirectory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
