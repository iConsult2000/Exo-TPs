package com.bookshop.models;

import java.util.ArrayList;
import java.util.Collection;

import com.bookshop.persistance.DetailsCommande;
import com.bookshop.persistance.Produit;

public class Cart {
	private Integer code_user;
	private Collection<Produit> listproduit = new ArrayList<Produit>();
	
	public Cart(){
		
	}

	/**
	 * @return the code_user
	 */
	public Integer getCode_user() {
		return code_user;
	}

	/**
	 * @param code_user the code_user to set
	 */
	public void setCode_user(Integer code_user) {
		this.code_user = code_user;
	}

	
	
	public int getNbrearticles() {
		if (this.listproduit.isEmpty()) {
			return 0;
			}else {
				return listproduit.size();
			}
	}

	/**
	 * @return the listproduit
	 */
	public Collection<Produit> getListproduit() {
		return listproduit;
	}

	/**
	 * @param listproduit the listproduit to set
	 */
	public void setListproduit(Collection<Produit> listproduit) {
		this.listproduit = listproduit;
	}
	
	
}
