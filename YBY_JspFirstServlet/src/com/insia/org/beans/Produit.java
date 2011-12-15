package com.insia.org.beans;

import java.io.Serializable;


public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;
    
	private String Libelle;
	private int prix;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produit() {
        super();
        // TODO Auto-generated constructor stub
    }


	public String getLibelle() {
		return Libelle;
	}


	public void setLibelle(String libelle) {
		Libelle = libelle;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}

    

}
