package com.my.company.adapterpattern.example1;
import com.my.company.adapterpattern.example1.duck.Duck;
import com.my.company.adapterpattern.example1.turkey.Turkey;

import java.util.Random;

public class DuckAdapter implements Turkey {
	Duck duck;
	Random rand;
 
	public DuckAdapter(Duck duck) {
		this.duck = duck;
		rand = new Random();
	}
    
	public void gobble() {
		duck.quack();
	}
  
	public void fly() {
		if (rand.nextInt(5)  == 0) {
		     duck.fly();
		}
	}
}
