package com.sqli.bookShop.persistance;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {

	public Client(){
	}
	
	private int identifiant;
	
	private String nom;
	
	private String prenom;
	
	private float prix;
	
	private List<Commande> commandes;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
	
}
