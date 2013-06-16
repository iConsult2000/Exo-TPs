package com.pizzeria.model;


import java.util.ArrayList;

import com.pizzeria.ingredient.model.Ingredient;
import com.pizzeria.pizza.model.Pizza;
import com.pizzeria.pizza.model.Pizza4fromages;
import com.pizzeria.pizza.model.PizzaCustom;
import com.pizzeria.pizza.model.PizzaMargherita;
import com.pizzeria.pizza.model.PizzaOriental;
import com.pizzeria.pizza.model.PizzaVegetarienne;


public class SimpleFabriqueDePizza {
		
	
	public Pizza creerPizza(String type) {
		Pizza pizza = null;
		if (type.equals("Oriental")) {
		pizza = new PizzaOriental();
		} else if (type.equals("Margherita")) {
		pizza = new PizzaMargherita();
		} else if (type.equals("4fromages")) {
		pizza = new Pizza4fromages();
		} else if (type.equals("vegetarienne")) {
		pizza = new PizzaVegetarienne();
		} return pizza;
		}
	
	
	public Pizza creerPizza(ArrayList<Ingredient> ingredients){
		Pizza pizza = new PizzaCustom(ingredients);
		
		return pizza;
		
	}
	
}
	
