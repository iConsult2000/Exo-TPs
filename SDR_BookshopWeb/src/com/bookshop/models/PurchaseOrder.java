package com.bookshop.models;

import java.util.Collection;

import com.bookshop.persistance.Produit;

public class PurchaseOrder {
	private int no_commande;
	private Collection<Produit> listProduits;
	private double montant;
	/**
	 * @return the no_commande
	 */
	public int getNo_commande() {
		return no_commande;
	}
	/**
	 * @param no_commande the no_commande to set
	 */
	public void setNo_commande(int no_commande) {
		this.no_commande = no_commande;
	}
	/**
	 * @return the listProduits
	 */
	public Collection<Produit> getListProduits() {
		return listProduits;
	}
	/**
	 * @param listProduits the listProduits to set
	 */
	public void setListProduits(Collection<Produit> listProduits) {
		this.listProduits = listProduits;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		this.montant = 0;
		for (Produit p : listProduits) {
			this.montant = this.montant + p.getPrix_unitaire();
		}
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Collection<Produit> listProduits) {
		
		this.montant = 0;
		for (Produit p : listProduits) {
			this.montant = this.montant + p.getPrix_unitaire();
		}
		
	}
	
	
}
