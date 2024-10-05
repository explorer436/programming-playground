package com.my.company.strategypattern.encryptionexample.withinheritance;

public class TestDriver {
    public static void main(String[] args) {
        AesEncryptor aesEncryptor = new AesEncryptor("This is plain text");
        aesEncryptor.encrypt();

        BlowfishEncryptor blowfishEncryptor = new BlowfishEncryptor("This is plain text");
        blowfishEncryptor.encrypt();
    }
}
