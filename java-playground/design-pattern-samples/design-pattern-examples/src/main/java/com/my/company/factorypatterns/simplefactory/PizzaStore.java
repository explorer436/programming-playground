package com.my.company.factorypatterns.simplefactory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaStore {

	private final SimplePizzaFactory factory;
 
	public Pizza orderPizza(String type) {

		Pizza pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
