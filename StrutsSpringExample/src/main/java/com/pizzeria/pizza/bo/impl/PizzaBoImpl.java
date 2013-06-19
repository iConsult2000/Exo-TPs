package com.pizzeria.pizza.bo.impl;

import java.util.List;

import com.pizzeria.pizza.bo.PizzaBo;
import com.pizzeria.pizza.dao.PizzaDao;
import com.pizzeria.pizza.model.Pizza;

public class PizzaBoImpl implements PizzaBo {
	
	PizzaDao pizzaDao;

	
	public void setPizzaDao(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
	
	public void addPizza(Pizza pizza) {
		
		pizzaDao.addPizza(pizza);
		
	}

	public List<Pizza> findAllPizza() {
		
		return pizzaDao.findAllPizza();
	}

}
