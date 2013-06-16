package com.pizzeria.pizza.model;


import com.pizzeria.ingredient.model.PateEpaisse;
import com.pizzeria.ingredient.model.Pates;


public class PizzaVegetarienne extends Pizza {
	
	
	public PizzaVegetarienne (){
		
		this.nom = "Vegetarienne" ;
		Pates pate = new PateEpaisse();
	}


}
