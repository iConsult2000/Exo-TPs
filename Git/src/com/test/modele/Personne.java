package com.test.modele;

public class Personne {
	
	private String nom ;
	private String prenom ;
	private Adresse adresse;
	
	public Personne() {
		super();
	}
	
	public Personne(String nom, String prenom, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + "]";
	}		
}
