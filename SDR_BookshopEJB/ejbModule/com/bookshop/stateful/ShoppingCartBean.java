package com.bookshop.stateful;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Remove;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.ejb3.context.spi.SessionContext;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.DetailsCommande;
import com.bookshop.persistance.DetailsCommandePK;
import com.bookshop.persistance.Produit;

/**
 * Session Bean implementation class ShoppingCartBean
 */

@Stateful(name = "ShoppingCart")
public class ShoppingCartBean implements ShoppingCartBeanRemote,
		ShoppingCartBeanLocal, Serializable, SessionSynchronization {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ShoppingCartBean() {
		// TODO Auto-generated constructor stub
	}

	private Collection<DetailsCommande> newlistlignedecommande = new ArrayList<DetailsCommande>();
	private Collection<Produit> listProduits = new ArrayList<Produit>();
	public Commande initializeCommande() {

		Commande commande = new Commande();
		Calendar currentDate = Calendar.getInstance();
		commande.setDate_commande(currentDate.getTime()); // Mandatory
		commande.setNo_employe(10); // Mandatory web account
		newlistlignedecommande = null;
		listProduits = null;
		return commande;
	}

	public Commande getCommande(int no_commande) {
		System.out.println("Finding commande in progress...");
		Commande commande = em.find(Commande.class, no_commande);
		System.out.println("La commande trouvée est : "
				+ commande.getNumeroCommande());
		System.out.println("getCommande done");
		return commande;
	}

	public Commande addCommande(
			Collection<DetailsCommande> listlignedecommande, String code_client) {

		Commande commande = initializeCommande();

		System.out.println("addLigneCommande in progress...");
		commande.setCode_client(code_client); // Mandatory
		em.persist(commande);
		// Sauver chaque ligne de commande

		for (DetailsCommande eachline : listlignedecommande) {
			eachline.getPk().setNo_commande(commande.getNumeroCommande());
			em.persist(eachline);
		}

		commande.setDetailsCommande(listlignedecommande);
		em.merge(commande);
		System.out.println("addLigneCommande in done");
		return commande;
	}

	public void addLigneCommande(int numeroProduit, int quantite,
			float... remise) {
		// Création de la ligne de commande et mise en collection
		DetailsCommande lignedecommande = new DetailsCommande();
		DetailsCommandePK dcPK = new DetailsCommandePK();

		dcPK.setRef_produit(numeroProduit);
		lignedecommande.setPk(dcPK);

		// Ajout d'une unite
		lignedecommande.setQuantite(quantite);

		// Pas de remise
		if (remise.length > 0) {
			lignedecommande.setRemise(remise[0]);
		} else {
			lignedecommande.setRemise(0);
		}

		// Recherche du produit
		Produit produit = em.find(Produit.class, numeroProduit);
		lignedecommande.setPrix_unitaire(produit.getPrix_unitaire());

		newlistlignedecommande.add(lignedecommande);
		listProduits.add(produit);

	}

	public void removeLigneCommande(int numeroArticle) {
		System.out.println("removeLigneCommande in progress..");
		int i = 0;
		for (DetailsCommande e : newlistlignedecommande) {
			System.out.println("list passed n° " + i);
			if (e.getPk().getRef_produit() == numeroArticle) {
				if (newlistlignedecommande.remove(e)) {
					System.out.println("removeLigneCommande done..");
					break;
				} else {
					System.out.println("operation cancelled....");
				}
			}
			i++;
		}

	}

	public int validerAchat(String code_client){
		System.out.println("validerAchat in progress...");
		int result = 0;
		

	
			// renvoi du no_commande
			result = this.addCommande(newlistlignedecommande, code_client)
					.getNumeroCommande();
			

		
		return result;
	}
		
	

	@Remove
	public void checkout() {
		em.clear();
		em.close();
	}

	@Override
	public void afterBegin() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(boolean arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}



	
	public void beforeCompletion() throws EJBException, RemoteException {
		
		}

	}


