package com.sqli.bookShop.persistance;

import java.io.Serializable;
import java.util.Collection;

public class Commande implements Serializable {

	public Commande() {
		// TODO Auto-generated constructor stub
	}

	private Collection<LigneDeCommande> lignesDeCommande;
	
	private int numeroCommande;

	public Collection<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}

	public void setLignesDeCommande(Collection<LigneDeCommande> lignesDeCommande) {
		this.lignesDeCommande = lignesDeCommande;
	}

	public int getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public String toString() {
		return "Commande [lignesDeCommande=" + lignesDeCommande
				+ ", numeroCommande=" + numeroCommande + "]";
	}
	
	
	
}
