package com.pizzeria.pizza.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


@SuppressWarnings("serial")
public class PizzaForm  extends ActionForm{
	

	protected String nom;
	protected float prix;
	//protected ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}




	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
	
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}*/
	
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
	HttpServletRequest request) {
 
	    ActionErrors errors = new ActionErrors();
 
	    if( getNom() == null || ("".equals(getNom()))) {
	       errors.add("pizza.err.nom",
              new ActionMessage("pizza.err.nom.required"));
	    }
	    
	    if( getPrix() == 0 || ("".equals(getPrix()))) {
		   errors.add("pizza.err.prix",
	           new ActionMessage("pizza.err.prix.required"));
		}

	    return errors;
	}
 
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		prix = 0;
		nom = "";
	}
	
	

}
