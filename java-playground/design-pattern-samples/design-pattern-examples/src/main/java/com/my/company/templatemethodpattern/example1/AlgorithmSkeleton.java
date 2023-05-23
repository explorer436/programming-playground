package com.my.company.templatemethodpattern.example1;

public abstract class AlgorithmSkeleton {
    public void execute() {
        stepOne();
        stepTwo();
        stepThree();
        if(doClientRequire()){
            stepFour();
        }
    }
    final void stepOne() {
        System.out.println( "stepOne performed" );
    }
    abstract void stepTwo();
    abstract void stepThree();
    final void stepFour() {
        System.out.println( "stepFour performed" );
    }
    boolean doClientRequire () {
        return true;
    }
}

