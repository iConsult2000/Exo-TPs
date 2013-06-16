package com.pizzeria.pizza.model;


import com.pizzeria.ingredient.model.PateEpaisse;
import com.pizzeria.ingredient.model.Pates;


public class Pizza4fromages extends Pizza {
		
	
	public Pizza4fromages (){
		
		Pates pate = new PateEpaisse();
		this.nom = "4fromages" ;
		this.prix = 15;
	}

	
	
	

}
