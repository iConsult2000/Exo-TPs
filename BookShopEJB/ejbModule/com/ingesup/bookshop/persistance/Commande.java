package com.ingesup.bookshop.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroCommande;
	private Collection<LigneDeCommande> LigneDeCommande = new ArrayList<LigneDeCommande>();
	
	public Commande(){	}

	/**
	 * @return the numeroCommande
	 */
	@Id @GeneratedValue
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
	 * @return the ligneDeCommande
	 */
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="numeroCommande", referencedColumnName ="numeroCommande")
	public Collection<LigneDeCommande> getLigneDeCommande() {
		return LigneDeCommande;
	}

	/**
	 * @param ligneDeCommande the ligneDeCommande to set
	 */
	public void setLigneDeCommande(Collection<LigneDeCommande> ligneDeCommande) {
		LigneDeCommande = ligneDeCommande;
	}

	@ManyToOne
	public Client client;

}
