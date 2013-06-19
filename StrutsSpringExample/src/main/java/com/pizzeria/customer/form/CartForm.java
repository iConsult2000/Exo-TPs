package com.pizzeria.customer.form;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pizzeria.pizza.model.Pizza;

public class CartForm extends ActionForm {
	
    /* --------------- */
    /* -- CONSTANTES -- */
    /* --------------- */
	
	
	
    /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */
	
	

	
	private long code_user;
	private Collection<Pizza> listproduit = new ArrayList<Pizza>();
	
	
	
    /* --------------- */
    /* -- GETTER - SETTER -- */
    /* --------------- */
	
	/**
	 * @return the code_user
	 */
	public long getCode_user() {
		return code_user;
	}
	/**
	 * @param code_user the code_user to set
	 */
	public void setCode_user(long code_user) {
		this.code_user = code_user;
	}
	/**
	 * @return the listproduit
	 */
	public Collection<Pizza> getListproduit() {
		return listproduit;
	}
	/**
	 * @param listproduit the listproduit to set
	 */
	public void setListproduit(Collection<Pizza> listproduit) {
		this.listproduit = listproduit;
	}

	
	/*
	 * Error
	 */
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
	HttpServletRequest request) {
 
	    ActionErrors errors = new ActionErrors();
 

	    return errors;
	}
 
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		code_user = 0;
		listproduit = null;
	}
	
}

