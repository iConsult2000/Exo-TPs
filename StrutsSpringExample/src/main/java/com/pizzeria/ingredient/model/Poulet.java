package com.pizzeria.ingredient.model;

public class Poulet extends Ingredient {

	
	public Poulet(){
		this.nom = "Poulet r�ti";
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
