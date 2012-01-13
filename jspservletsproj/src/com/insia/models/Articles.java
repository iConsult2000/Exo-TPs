package com.insia.models;

public class Articles {

	private String nom;
	private float price;
	private String description;
	private String path_to_icon;
	
	public Articles(String nom, float price, String path_to_icon){
		this.nom = nom;
		this.price = price;
		this.path_to_icon = path_to_icon;

		
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
	
	public String getIcon() {
		return path_to_icon;
	}
	
	
}
