package com.pizzeria.pizza.bo;


import java.util.List;

import com.pizzeria.pizza.model.Pizza;


public interface PizzaBo {
	
	
void addPizza(Pizza pizza);
	
List<Pizza> findAllPizza();

}
