package com.my.company.singletonpattern.breakingsingleton.usingserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SingletonWithSerialized instanceOne = SingletonWithSerialized.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("test.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("test.ser"));
        SingletonWithSerialized instanceTwo = (SingletonWithSerialized) in.readObject();
        in.close();

        System.out.println("instanceOne-- " + instanceOne.hashCode());
        System.out.println("instanceTwo-- " + instanceTwo.hashCode());

        // output
        // instanceOne--      1011114567
        // instanceTwo--      1095644325
    }
}
