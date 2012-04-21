package com.sqli.bookShop.persistance;

import java.io.Serializable;


public class LigneDeCommande implements Serializable {

	public LigneDeCommande() {
		// TODO Auto-generated constructor stub
	}

	private Article article;

	private Commande commande;
	
	private int idLigneDeCommande;
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getIdLigneDeCommande() {
		return idLigneDeCommande;
	}

	public void setIdLigneDeCommande(int idLigneDeCommande) {
		this.idLigneDeCommande = idLigneDeCommande;
	}

	private int quantite;
	
	public void setArticle(Article article) {
		this.article = article;
	}

	public Article getArticle() {
		return article;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [article=" + article + ", quantite=" + quantite
				+ "]";
	}

	
	
}
