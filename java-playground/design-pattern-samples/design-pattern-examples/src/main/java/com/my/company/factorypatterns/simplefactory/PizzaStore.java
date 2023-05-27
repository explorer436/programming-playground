package com.my.company.factorypatterns.simplefactory;

public class PizzaStore {
 
	public Pizza orderPizza(String type) {

		SimplePizzaFactory factory = new SimplePizzaFactory();
		Pizza pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
