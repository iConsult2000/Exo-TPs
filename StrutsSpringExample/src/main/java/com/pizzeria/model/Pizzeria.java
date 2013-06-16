package com.pizzeria.model;


import java.util.ArrayList;

import com.pizzeria.ingredient.model.Ingredient;
import com.pizzeria.pizza.model.Pizza;


public class Pizzeria {
	
	public SimpleFabriqueDePizza fabrique;
	public ArrayList<Pizza> listPizza;
	
	public Pizzeria(SimpleFabriqueDePizza fabrique) {
		this.fabrique = fabrique;
		
	}



	public Pizza commanderPizza(String type){
		
		Pizza pizza;
		pizza = fabrique.creerPizza(type);
		
		return pizza;
	}
	
	
	public Pizza commanderPizza(ArrayList<Ingredient> ingredients){
		
		
		Pizza pizza;
		pizza = fabrique.creerPizza(ingredients);
		
		return pizza;
	}
	

}
