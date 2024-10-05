package com.my.company.strategypattern.encryptionexample.withinheritance;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class EncryptorSuper {

    public final String plainText;

    public abstract void encrypt();
}
