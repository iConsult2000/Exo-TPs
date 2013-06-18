package com.pizzeria.cart.model;

import java.util.Collection;

import com.pizzeria.pizza.model.*;

public class PurchaseOrder {
	private int no_commande;
	private Collection<Pizza> listProduits;
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
	public Collection<Pizza> getListProduits() {
		return listProduits;
	}
	/**
	 * @param listProduits the listProduits to set
	 */
	public void setListProduits(Collection<Pizza> listProduits) {
		this.listProduits = listProduits;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		this.montant = 0;
		for (Pizza p : listProduits) {
			this.montant = this.montant + p.getPrix();
		}
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Collection<Pizza> listProduits) {
		
		this.montant = 0;
		for (Pizza p : listProduits) {
			this.montant = this.montant + p.getPrix();
		}
		
	}
	
	
}
