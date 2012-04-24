package com.bookshop.persistance;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Categorie {
	
	private int code_categorie;
	private String nom_categorie;
	private String description;
	
	/**
	 * @return the code_categorie
	 */
	@Id
	public int getCode_categorie() {
		return code_categorie;
	}
	/**
	 * @param code_categorie the code_categorie to set
	 */
	public void setCode_categorie(int code_categorie) {
		this.code_categorie = code_categorie;
	}
	/**
	 * @return the nom_categorie
	 */
	public String getNom_categorie() {
		return nom_categorie;
	}
	/**
	 * @param nom_categorie the nom_categorie to set
	 */
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * One to many relation ship between Categorie and Produit
	 */
	@OneToMany(mappedBy = "code_categorie") 
	public Collection<Produit> getProduit() {
		return listedeproduit;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setProduit(Produit produit) {
		this.listedeproduit.add(produit);
	}
	
	private Collection<Produit> listedeproduit;
	
	
}
