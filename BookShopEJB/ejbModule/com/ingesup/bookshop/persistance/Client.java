package com.ingesup.bookshop.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identifiant;
	private String nom;
	private String prenom;
	private String motdePasse;
	private Collection<Commande> commande = new ArrayList<Commande>();
	
	public Client(){}

	/**
	 * @return the identifiant
	 */
	@Id @GeneratedValue
	public int getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the motdePasse
	 */
	public String getMotdePasse() {
		return motdePasse;
	}

	/**
	 * @param motdePasse the motdePasse to set
	 */
	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}

	/**
	 * @return the commande
	 */
	@OneToMany(mappedBy="numeroCommande")
	public Collection<Commande> getCommande() {
		return commande;
	}

	/**
	 * @param commande the commande to set
	 */
	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}


}
