package com.my.company.factorypatterns.simplefactory;

import com.my.company.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDrive {
 
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PizzaStore pizzaStore = ctx.getBean(PizzaStore.class);

		Pizza pizza = pizzaStore.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
 
		pizza = pizzaStore.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
	}
}
