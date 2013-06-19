package com.pizzeria.pizza.model;


import java.util.ArrayList;

import com.pizzeria.ingredient.model.Ingredient;


@SuppressWarnings("serial")
public abstract class Pizza implements java.io.Serializable {
	
	protected long pizzaId;
	protected String nom;
	protected float prix;
	protected ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}



	public long getPizzaId() {
		return pizzaId;
	}






	/**
	 * @param pizzaId the pizzaId to set
	 */
	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
	
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
	
	
}
