package com.ingesup.bookshop.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;





@Entity
public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroArticle;
	private String libelle;
	private float prix;
	
	public Article(){}
	
	public Article(int numeroArticle,String libelle, float prix){
		this.numeroArticle	=numeroArticle;
		this.libelle		=libelle;
		this.prix			=prix;
	}

	/**
	 * @return the numeroArticle
	 */
	@Id @GeneratedValue
	public int getNumeroArticle() {
		return numeroArticle;
	}

	/**
	 * @param numeroArticle the numeroArticle to set
	 */
	public void setNumeroArticle(int numeroArticle) {
		this.numeroArticle = numeroArticle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}

}
