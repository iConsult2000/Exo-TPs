package com.pizzeria.ingredient.model;

public class Poulet extends Ingredient {

	
	public Poulet(){
		this.nom = "Poulet r�ti";
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
