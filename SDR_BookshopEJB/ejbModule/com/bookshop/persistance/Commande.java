package com.bookshop.persistance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMMANDES")
public class Commande implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int no_commande;
	private String code_client;
	private int no_employe;
	private Date date_commande;
	private Date date_envoi;
	private int port;
	
	private Collection<DetailsCommande> listlignedecommande = new ArrayList<DetailsCommande>();

	public Commande() {

	}

	/**
	 * @return the numeroCommande
	 */
	@Id 
	@Column(name="no_commande")
	@GeneratedValue
	public int getNumeroCommande() {
		return no_commande;
	}

	/**
	 * @param numeroCommande
	 *            the numeroCommande to set
	 */
	public void setNumeroCommande(int numeroCommande) {
		this.no_commande = numeroCommande;
	}

	/**
	 * @return the code_client
	 */
	@Column(name="code_client", length=5)
	public String getCode_client() {
		return code_client;
	}

	/**
	 * @param code_client
	 *            the code_client to set
	 */
	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}

	/**
	 * @return the no_employe
	 */
	public int getNo_employe() {
		return no_employe;
	}

	/**
	 * @param no_employe
	 *            the no_employe to set
	 */
	public void setNo_employe(int no_employe) {
		this.no_employe = no_employe;
	}

	/**
	 * @return the date_commande
	 */
	public Date getDate_commande() {
		return date_commande;
	}

	/**
	 * @param date_commande
	 *            the date_commande to set
	 */
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	/**
	 * @return the date_envoi
	 */
	public Date getDate_envoi() {
		return date_envoi;
	}

	/**
	 * @param date_envoi
	 *            the date_envoi to set
	 */
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * One to many relation ship between DetailsCommande and Commande
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="no_commande", referencedColumnName = "no_commande") 
	public Collection<DetailsCommande> getDetailsCommande() {
		System.out.println("execute Commande getDetailsCommande() method");	
		return this.listlignedecommande;
	}
	
	public void setDetailsCommande(Collection<DetailsCommande> listlignedecommande) {
		System.out.println("execute Commande setDetailsCommande() method");
		this.listlignedecommande = listlignedecommande;
		
	}
	
	
	/**
	 * Generics must be used so that the container can determine the bean order
	 * is related to.
	 * 
	 * CascadeType.ALL specifies that when an Order is created, any LineItems
	 * held in the lineItems collection will be created as well
	 * (CascadeType.PERSIST). If the Order is delete from persistence storage,
	 * all related LineItems will be deleted (CascadeType.REMOVE). If an Order
	 * instance is reattached to persistence storage, any changes to the
	 * LineItems collection will be merged with persistence storage
	 * (CascadeType.MERGE).
	 * 
	 * FetchType.EAGER specifies that when the Order is loaded whether or not to
	 * prefetch the relationship as well. If you want the LineItems to be loaded
	 * on demand, then specify FetchType.LAZY.
	 * 
	 * The mappedBy attribute specifies that this is a bi-directional
	 * relationship that is managed by the order property on the LineItem entity
	 * bean.
	 */
	
	/**
	 * DetailsCommande completes the bi-directional between Commande and DetailsCommande. 
	 * The @JoinColumn specifies the foreign key column within the DetailsCommande table. 
	 * @return
	 */
	@ManyToOne
	 public Client client;
}
