package com.sqli.bookShop.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findLigne", query = "SELECT l FROM LigneDeCommande l WHERE idLigneDeCommande = :idLigneDeCommande")
    })
public class LigneDeCommande implements Serializable {

	private int idLigneDeCommande;
	private int quantite;
	
	@JoinColumn(name = "article", referencedColumnName = "id_article")
	@ManyToOne(optional = false)
	private Article article;
	

    @JoinColumn(name = "commande", referencedColumnName = "id_commande")
    @ManyToOne(optional = false)
	private Commande commande;
	
	
	//Constructeur
	public LigneDeCommande() {

	}
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	@Id
	@GeneratedValue
	public int getIdLigneDeCommande() {
		return idLigneDeCommande;
	}

	public void setIdLigneDeCommande(int idLigneDeCommande) {
		this.idLigneDeCommande = idLigneDeCommande;
	}
	
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

	
	
}
