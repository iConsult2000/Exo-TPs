package com.bookshop.persistance;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUITS")
public class Produit implements java.io.Serializable {

	private static final long serialVersionUID = 8293392041711334540L;
	
	
	private int ref_produit;
	
	private String nom_produit;
	private int no_fournisseur;
	private int code_categorie;
	private String quantite;
	private int prix_unitaire;
	private int unites_stock;
	private int unites_commandees;
	private int indisponible;
	
	public Produit(){
		
	}

	/**
	 * @return the ref_produit
	 */
	@Id	
	public int getRef_produit() {
		return ref_produit;
	}

	/**
	 * @param ref_produit the ref_produit to set
	 */
	public void setRef_produit(int ref_produit) {
		this.ref_produit = ref_produit;
	}

	/**
	 * @return the nom_produit
	 */
	public String getNom_produit() {
		return nom_produit;
	}

	/**
	 * @param nom_produit the nom_produit to set
	 */
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}

	/**
	 * @return the no_fournisseur
	 */
	public int getNo_fournisseur() {
		return no_fournisseur;
	}

	/**
	 * @param no_fournisseur the no_fournisseur to set
	 */
	public void setNo_fournisseur(int no_fournisseur) {
		this.no_fournisseur = no_fournisseur;
	}

	/**
	 * @return the code_categorie
	 */
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
	 * @return the quantite
	 */
	public String getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix_unitaire
	 */
	public int getPrix_unitaire() {
		return prix_unitaire;
	}

	/**
	 * @param prix_unitaire the prix_unitaire to set
	 */
	public void setPrix_unitaire(int prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	/**
	 * @return the unitees_stock
	 */
	public int getUnites_stock() {
		return unites_stock;
	}

	/**
	 * @param unitees_stock the unitees_stock to set
	 */
	public void setUnites_stock(int unites_stock) {
		this.unites_stock = unites_stock;
	}

	/**
	 * @return the unites_commande
	 */
	public int getUnites_commandees() {
		return unites_commandees;
	}

	/**
	 * @param unites_commande the unites_commande to set
	 */
	public void setUnites_commandees(int unites_commandees) {
		this.unites_commandees = unites_commandees;
	}

	/**
	 * @return the indisponible
	 */
	public int getIndisponible() {
		return indisponible;
	}

	/**
	 * @param indisponible the indisponible to set
	 */
	public void setIndisponible(int indisponible) {
		this.indisponible = indisponible;
	}
	
	/**
	 * @return the complete record
	 */
	public String toString(){
		return "Produit n° " + ref_produit + System.getProperty("line.separator") +
				"NOM_PRODUIT : " + nom_produit + System.getProperty("line.separator") +
				"NO_FOURNISSEUR : " + no_fournisseur + System.getProperty("line.separator") +
				"CODE_CATEGORIE : " + code_categorie + System.getProperty("line.separator") +
				"QUANTITE : " + quantite + System.getProperty("line.separator") +
				"PRIX_UNITAIRE : " + prix_unitaire + System.getProperty("line.separator") + 
				"UNITES_STOCK : " + unites_stock + System.getProperty("line.separator") +
				"UNITES_COMMANDEES : " + unites_commandees + System.getProperty("line.separator") +
				"INDISPONIBLE : " + indisponible + System.getProperty("line.separator");
		
	}
	
	/**
	 * DetailsCommande completes the bi-directional between Commande and DetailsCommande. 
	 * The @JoinColumn specifies the foreign key column within the DetailsCommande table. 
	 * @return
	 */
	@ManyToOne
	public Categorie categorie;
		
	/**
	 * One to many relation ship between DetailsCommande and Commande
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ref_produit", referencedColumnName="ref_produit") 
	public Collection<DetailsCommande> getDetailsCommande() {
		return lignedecommande;
	}
	public void setDetailsCommande(Collection<DetailsCommande> lignedecommande) {
		this.lignedecommande = lignedecommande;
	}
	private Collection<DetailsCommande> lignedecommande;
	
	
	
	
	
	
	
	
	
}
