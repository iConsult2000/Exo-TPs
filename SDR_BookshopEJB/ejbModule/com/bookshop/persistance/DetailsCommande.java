package com.bookshop.persistance;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETAILS_COMMANDES")
public class DetailsCommande implements java.io.Serializable {

	@EmbeddedId
	public DetailsCommandePK getPk() {
		return pk;
	}

	public void setPk(DetailsCommandePK pk) {
		this.pk = pk;
	}

	private DetailsCommandePK pk;

	public DetailsCommande() {
	}

	/**
	 * @return the prix_unitaire
	 */
	@Column(name = "prix_unitaire")
	public int getPrix_unitaire() {
		return prix_unitaire;
	}

	/**
	 * @param prix_unitaire
	 *            the prix_unitaire to set
	 */
	public void setPrix_unitaire(int prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	private int prix_unitaire;

	/**
	 * @return the quantite
	 */
	@Column(name = "quantite")
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	private int quantite;

	/**
	 * @return the remise
	 */
	public float getRemise() {
		return remise;
	}

	/**
	 * @param remise2[]
	 *            the remise to set
	 */
	public void setRemise(float remise2) {
		this.remise = remise2;
	}

	private float remise;

	


	

}
