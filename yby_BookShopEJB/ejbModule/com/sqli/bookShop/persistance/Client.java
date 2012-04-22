package com.sqli.bookShop.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	public Client(){
	}
	

	private int identifiant;	
	private String nom;
	private String prenom;

	public Collection<Commande> commandeList = new ArrayList<Commande>();
	
	@Id
	@GeneratedValue
	@Column(name = "id_client")
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	@Column( length = 50)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column( length = 50)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@OneToMany(mappedBy = "client")
	public Collection<Commande> getCommandes() {
		return commandeList;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandeList = commandes;
	}
	
	
	
	
}
