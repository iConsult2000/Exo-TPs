package com.pizzeria.ingredient.model;



public class PateFine extends Pates {
	
	
	public PateFine(){
		
		this.prix = (float) 0.5;
		
	}
	@Override
	public long getIngredientId() {
		// TODO Auto-generated method stub
		return ingredientId;
	}

	@Override
	public float getPrix() {
		// TODO Auto-generated method stub
		return prix;
	}

}
