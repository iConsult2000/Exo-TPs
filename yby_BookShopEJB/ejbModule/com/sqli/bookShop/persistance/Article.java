package com.sqli.bookShop.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = "findAllArticles", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "findAllArticleFromFiliere", query = "SELECT a FROM Article a WHERE filiere = :filiere"),
    })
public class Article  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7982388395078212643L;
	
	private int numeroArticle;
	private String filiere;
	private String libelle;
	private float prix;
	private int quantite;
	
	public Collection<LigneDeCommande> ligneList = new ArrayList<LigneDeCommande>();

	public Article() {

	}
	
	
	@OneToMany(mappedBy = "article")
	public Collection<LigneDeCommande> getLigneList() {
		return ligneList;
	}

	public void setLigneList(Collection<LigneDeCommande> ligneList) {
		this.ligneList = ligneList;
	}

	@Column( length = 50)
	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_article")
	public int getNumeroArticle() {
		return numeroArticle;
	}
	@Column( length = 50)
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

		
}
