package com.pizzeria.ingredient.model;

public class Jambon extends Ingredient {

	
	
	public Jambon(){
		
		this.nom = "Jambon";
	}
	
	@Override
	public float getPrix() {
		// TODO Auto-generated method stub
		return prix;
	}
	@Override
	public long getIngredientId() {
		// TODO Auto-generated method stub
		return ingredientId;
	}

}
