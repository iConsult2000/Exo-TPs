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
	private int id_commande;
	private int id_article;
	
	
	
	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

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
