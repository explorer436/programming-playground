package com.my.company;

public class VendingMachineFactory {

    public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl();
    }

}
