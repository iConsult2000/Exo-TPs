package com.sqli.bookShop.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	
	private int numeroCommande = 0;
	private int id_client;
	
	public Collection<LigneDeCommande> lignesDeCommande = new ArrayList<LigneDeCommande>();
	
   
	
	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	@Id
	//@GeneratedValue
	@Column(name = "id_commande")
	public int getNumeroCommande() {
		return numeroCommande;
	}

	@JoinColumn(name = "client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
	private Client client;

	
	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Commande() {
		this.numeroCommande++;
	}
	
	@OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
	public Collection<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}

	public void setLignesDeCommande(Collection<LigneDeCommande> lignesDeCommande) {
		this.lignesDeCommande = lignesDeCommande;
	}


	
	
}
