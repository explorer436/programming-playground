package com.my.company.strategypattern.encryptionexample.withinheritance;

import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class BlowfishEncryptor extends EncryptorSuper {

    public BlowfishEncryptor(String plainText) {
        super(plainText);
    }

    public void encrypt() {
            System.out.println("Encrypting data using Blowfish algorithm");
            /*Code to encrypt data using Blowfish algorithm */
            encryptDataUsingBlowfishAlgorithm(plainText);
        /*More else if statements for other encryption algorithms*/
    }

    private void encryptDataUsingBlowfishAlgorithm(String plaintext) {
        System.out.println("\n-------Encrypting data using Blowfish algorithm-------");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] plaintTextByteArray = plaintext.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plaintTextByteArray);
            System.out.println("Original data: " + plaintext);
            System.out.println("Encrypted data:");
            for (int i = 0; i < cipherText.length; i++) {
                System.out.print(cipherText[i] + " ");
            }
            System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
