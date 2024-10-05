package com.my.company.strategypattern.encryptionexample.withoutinheritanceorthepattern;

public class TestDriver {
    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor("Aes", "This is plain text");
        encryptor.encrypt();

        encryptor = new Encryptor("Blowfish", "This is plain text");
        encryptor.encrypt();
    }
}
