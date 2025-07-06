package com.my.company;

public class SampleDaemonThread extends Thread
{
    /*public SampleDaemonThread(){
        setDaemon(true);
    }*/
    public void run(){
        System.out.println("Is SampleDaemonThread thread Daemon? - "+isDaemon());
    }
}
