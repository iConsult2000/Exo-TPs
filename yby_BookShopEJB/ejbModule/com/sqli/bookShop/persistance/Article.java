package com.sqli.bookShop.persistance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Article  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7982388395078212643L;

	public Article() {
		super();
	}

	private int numeroArticle;
	private String filiere;
	private float prix;

	@Column( length = 55)
	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Id
	@GeneratedValue
	public int getNumeroArticle() {
		return numeroArticle;
	}

	public void setNumeroArticle(int numeroArticle) {
		this.numeroArticle = numeroArticle;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	
	
}
