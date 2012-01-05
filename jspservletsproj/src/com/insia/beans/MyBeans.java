package com.insia.beans;

import java.io.Serializable;

public class MyBeans implements Serializable {

	private String nomProduit;
	private double prix;
	
	public MyBeans(String nomProduit, double prix){this.nomProduit=nomProduit; this.prix=prix;}
	
	public String getNomProduit(){ return nomProduit; }
	
	public double getPrix(){ return prix; }
	
	public void setNomProduit(String n){ nomProduit=n; }
	
	public void setPrix(double p){ prix=p; }
}
