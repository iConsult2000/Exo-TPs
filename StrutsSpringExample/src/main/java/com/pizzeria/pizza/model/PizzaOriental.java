package com.pizzeria.pizza.model;


import com.pizzeria.ingredient.model.PateEpaisse;
import com.pizzeria.ingredient.model.Pates;

public class PizzaOriental extends Pizza {
	
	
	
	public PizzaOriental (){
		
		this.nom = "Oriental" ;
		this.prix = 17;
		Pates pate = new PateEpaisse();
	}
	
	
	
	

}
