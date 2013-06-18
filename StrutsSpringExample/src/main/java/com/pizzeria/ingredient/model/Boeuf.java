package com.pizzeria.ingredient.model;

public class Boeuf extends Ingredient {

	
	public Boeuf(){
		
		this.nom = "Boulette de boeuf";
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
