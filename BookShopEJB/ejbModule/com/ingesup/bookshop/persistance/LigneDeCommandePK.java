package com.ingesup.bookshop.persistance;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Embeddable
public class LigneDeCommandePK implements Serializable{
	private int numeroCommande;
	private int numeroArticle;
	
	public LigneDeCommandePK(){}
	
	public LigneDeCommandePK(int numeroCommande, int numeroArticle){
		this.numeroArticle = numeroArticle;
		this.numeroCommande = numeroCommande;
	}
	
	/**
	 * @return the numeroCommande
	 */
	public int getNumeroCommande() {
		return numeroCommande;
	}
	/**
	 * @param numeroCommande the numeroCommande to set
	 */
	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	/**
	 * @return the numeroArticle
	 */
	public int getNumeroArticle() {
		return numeroArticle;
	}
	/**
	 * @param numeroArticle the numeroArticle to set
	 */
	public void setNumeroArticle(int numeroArticle) {
		this.numeroArticle = numeroArticle;
	}
	
	@ManyToOne
	public Commande commande;
}
