package com.pizzeria.ingredient.model;



public abstract class Pates extends Ingredient {
	
	public Pates(){
		this.nom = "Pates";
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
