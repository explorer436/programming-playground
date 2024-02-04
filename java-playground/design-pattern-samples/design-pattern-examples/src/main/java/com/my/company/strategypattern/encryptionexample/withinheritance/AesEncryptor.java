package com.my.company.strategypattern.encryptionexample.withinheritance;

import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AesEncryptor extends EncryptorSuper {


    public AesEncryptor(String plainText) {
        super(plainText);
    }

    public void encrypt() {
            System.out.println("Encrypting data using AES algorithm");
            /*Code to encrypt data using AES algorithm*/
            encryptDataUsingAESAlgorithm(plainText);
    }
    /*Getter and setter methods for plainText*/

    private void encryptDataUsingAESAlgorithm(String plaintext) {
        System.out.println("-------Encrypting data using AES algorithm-------");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] plaintTextByteArray = plaintext.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("AES");
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
