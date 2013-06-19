package com.pizzeria.pizza.dao;

import java.util.List;

import com.pizzeria.pizza.model.Pizza;


public interface PizzaDao {
	
	
void addPizza(Pizza pizza);
	
	List<Pizza> findAllPizza();

}
