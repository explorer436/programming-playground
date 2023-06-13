package com.my.company.strategypattern.withoutthepattern;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encryptor {
    private String algorithmName;
    private String plainText;

    public Encryptor(String algorithmName) {
        this.algorithmName = algorithmName;
    }

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

    public void encryptDataUsingAESAlgorithm(String plaintext) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void encryptDataUsingBlowfishAlgorithm(String plaintext) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
