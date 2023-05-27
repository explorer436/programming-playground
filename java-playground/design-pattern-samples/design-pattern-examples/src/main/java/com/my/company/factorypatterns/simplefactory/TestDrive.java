package com.my.company.factorypatterns.simplefactory;

public class TestDrive {
 
	public static void main(String[] args) {

		// PizzaStore store = new PizzaStore(factory);
		PizzaStore store = new PizzaStore();

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
	}
}
