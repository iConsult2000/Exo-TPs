package com.pizzeria.pizza.model;


import com.pizzeria.ingredient.model.PateEpaisse;
import com.pizzeria.ingredient.model.Pates;


public class PizzaMargherita extends Pizza {
	
	
	public PizzaMargherita (){
		
		this.nom = "Margherita";
		Pates pate = new PateEpaisse();
		this.prix = 12;
		
		
	}

}
