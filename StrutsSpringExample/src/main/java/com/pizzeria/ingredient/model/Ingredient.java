package com.pizzeria.ingredient.model;

public abstract class Ingredient {
 
	protected long ingredientId;
	protected String nom;
	protected float prix;

 public abstract long getIngredientId();
 public abstract float getPrix();


}
