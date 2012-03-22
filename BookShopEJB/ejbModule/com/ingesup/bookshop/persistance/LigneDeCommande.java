package com.ingesup.bookshop.persistance;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LigneDeCommande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantite;
	private Article article;
	
	public LigneDeCommande(){}
	
	@EmbeddedId
	private LigneDeCommandePK pk;

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the pk
	 */
	public LigneDeCommandePK getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(LigneDeCommandePK pk) {
		this.pk = pk;
	}

}
