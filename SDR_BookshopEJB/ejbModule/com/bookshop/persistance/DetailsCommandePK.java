package com.bookshop.persistance;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DetailsCommandePK implements java.io.Serializable {

	public DetailsCommandePK() {

	}

	public DetailsCommandePK(int no_commande, int ref_produit) {
		this.no_commande = no_commande;
		this.ref_produit = ref_produit;
	}

	/**
	 * @return the no_commande
	 */
	
	public int getNo_commande() {
		return no_commande;
	}

	/**
	 * @param no_commande
	 *            the no_commande to set
	 */
	public void setNo_commande(int no_commande) {
		this.no_commande = no_commande;
	}

	private int no_commande;

	/**
	 * @return the ref_produit
	 */
	
	public int getRef_produit() {
		return ref_produit;
	}

	/**
	 * @param ref_produit
	 *            the ref_produit to set
	 */
	public void setRef_produit(int ref_produit) {
		this.ref_produit = ref_produit;
	}

	private int ref_produit;

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof DetailsCommandePK))
			return false;
		if (obj == null)
			return false;
		DetailsCommandePK pk = (DetailsCommandePK) obj;
		return pk.ref_produit == ref_produit && pk.no_commande == no_commande;
	}
	
	/**
	 * DetailsCommande completes the bi-directional between Commande and
	 * DetailsCommande. The @JoinColumn specifies the foreign key column within
	 * the DetailsCommande table.
	 * 
	 * @return
	 */
	@ManyToOne	
	public Commande commande;

	/**
	 * DetailsCommande completes the bi-directional between Commande and
	 * DetailsCommande. The @JoinColumn specifies the foreign key column within
	 * the DetailsCommande table.
	 * 
	 * @return
	 */
	@ManyToOne
	public Produit produit;
}
