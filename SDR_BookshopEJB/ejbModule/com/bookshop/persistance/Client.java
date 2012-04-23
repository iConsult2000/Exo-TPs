package com.bookshop.persistance;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="CLIENTS")
public class Client implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code_client;
	private String societe;
	private String adresse;
	private String ville;
	private String code_postal;
	private String pays;
	private String telephone;
	private String fax;
	
	
	
	public Client() {
		
	}


	/**
	 * @return the code_client
	 */
	@Id
	@Column(length=5)
	public String getCode_client() {
		return code_client;
	}


	/**
	 * @param code_client the code_client to set
	 */
	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}


	/**
	 * @return the societe
	 */
	public String getSociete() {
		return societe;
	}


	/**
	 * @param societe the societe to set
	 */
	public void setSociete(String societe) {
		this.societe = societe;
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}


	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}


	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}


	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}


	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}


	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}


	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * One to many relation ship between DetailsCommande and Commande
	 */
	@OneToMany(mappedBy="code_client")
	public Collection<Commande> getCommande() {
		return listcommande;
	}
	
	public void setCommande(Commande commande) {
		this.listcommande.add(commande); //unidirectional;
	}
	
	private Collection<Commande> listcommande;
	
}
