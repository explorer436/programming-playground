package com.my.company;

import com.my.company.model.Data;
import com.my.company.receiver.Receiver;
import com.my.company.sender.Sender;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "starting ..." );

        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
