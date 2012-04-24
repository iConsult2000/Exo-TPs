package com.bookshop.models;

import java.util.List;

import com.bookshop.persistance.Produit;

public class StoreMag {

	private List<Produit> listProd;
	
	public StoreMag(){
		
	}
	
	public List<Produit> getStore() {
		return listProd;
	}
	
	public void addStore(List<Produit> listProd) {
		this.listProd = listProd;
	}
}
