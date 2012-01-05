package com.insia.org.models;

public class Article {

	private String ref;
	private float price;
	private String description;
	private String libelle;
	
	public Article(String ref, float price,	String description, String libelle){
		this.ref = ref;
		this.price = price;
		this.description = description;
		this.libelle = libelle;
		
		
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
