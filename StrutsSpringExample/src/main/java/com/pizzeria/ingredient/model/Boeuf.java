package com.pizzeria.ingredient.model;

public class Boeuf extends Ingredient {

	
	public Boeuf(){
		
		this.nom = "Boulette de boeuf";
	}
	
	
	@Override
	public float getPrix() {
		// TODO Auto-generated method stub
		return (float) 1.5;
	}


	@Override
	public long getIngredientId() {
		// TODO Auto-generated method stub
		return ingredientId;
	}

}
