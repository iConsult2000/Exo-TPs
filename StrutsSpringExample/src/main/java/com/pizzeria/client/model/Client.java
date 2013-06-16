package com.pizzeria.client.model;

public class Client {
	

	private long clientId;
	private String nom;
	private String prenom;
	private String tel;
	private String adresse;
	
	
	
	/**
	 * @return the clientId
	 */
	public long getClientId() {
		return clientId;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
