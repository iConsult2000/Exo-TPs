package com.insia.org.models;


public class cart {
	private Article item;
	private int qte;
	
	public cart(Article item, int qte){
		this.item = item;
		this.qte = qte;
	}

	public Article getItem() {
		return item;
	}

	public int getQte() {
		return qte;
	}
	
	
}