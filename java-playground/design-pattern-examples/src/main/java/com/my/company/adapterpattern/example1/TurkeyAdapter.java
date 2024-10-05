package com.my.company.adapterpattern.example1;

import com.my.company.adapterpattern.example1.duck.Duck;
import com.my.company.adapterpattern.example1.turkey.Turkey;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
