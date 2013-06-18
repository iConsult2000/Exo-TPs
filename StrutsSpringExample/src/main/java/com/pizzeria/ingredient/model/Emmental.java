package com.pizzeria.ingredient.model;

public class Emmental extends Ingredient {

	
	public Emmental(){
		
		this.nom = "Emmental";
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
