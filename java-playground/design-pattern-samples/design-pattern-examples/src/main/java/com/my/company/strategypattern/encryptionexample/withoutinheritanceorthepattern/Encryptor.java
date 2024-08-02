package com.my.company.strategypattern.encryptionexample.withoutinheritanceorthepattern;

import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@RequiredArgsConstructor
public class Encryptor {
    private final String algorithmName;
    private final String plainText;

    public void encrypt() {
        if (algorithmName.equals("Aes")) {
            System.out.println("Encrypting data using AES algorithm");
            /*Code to encrypt data using AES algorithm*/
            encryptDataUsingAESAlgorithm(plainText);
        } else if (algorithmName.equals("Blowfish")) {
            System.out.println("Encrypting data using Blowfish algorithm");
            /*Code to encrypt data using Blowfish algorithm */
            encryptDataUsingBlowfishAlgorithm(plainText);
        }
        /*More else if statements for other encryption algorithms*/
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
