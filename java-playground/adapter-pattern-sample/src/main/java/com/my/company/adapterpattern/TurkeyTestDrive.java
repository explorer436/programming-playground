package com.my.company.adapterpattern;

import com.my.company.adapterpattern.duck.MallardDuck;
import com.my.company.adapterpattern.turkey.Turkey;

public class TurkeyTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		Turkey duckAdapter = new DuckAdapter(duck);
 
		for(int i=0;i<10;i++) {
			System.out.println("The DuckAdapter says...");
			duckAdapter.gobble();
			duckAdapter.fly();
		}
	}
}
