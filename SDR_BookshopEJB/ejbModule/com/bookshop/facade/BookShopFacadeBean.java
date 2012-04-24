package com.bookshop.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.Produit;

/**
 * Session Bean implementation class BookShopFacadeBean
 */
@Stateless(name="BookShopStateless", description="My BookShopFacadeEJB")
@Remote(BookShopFacadeBeanRemote.class)
@Local(BookShopFacadeBeanLocal.class)

public class BookShopFacadeBean implements BookShopFacadeBeanRemote, BookShopFacadeBeanLocal, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext EntityManager em;
	
	/**
     * Default constructor. 
     */
    public BookShopFacadeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Produit> getAllArticlesFromFiliere(String filiere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> getAllArticles() {
		System.out.println("listerTousLesProduits in progress");
		Query qSQL = em.createQuery("SELECT p FROM Produit p ");
		List<Produit> results = qSQL.getResultList();
		return results;
	}

	
	public void addArticle(Produit article) {
		System.out.println("Enregistrement en cours");
		em.persist(article);
		System.out.println("Enregistrement terminée");
	}

	public Produit rechercherProduit(int ref_produit) {	
		System.out.println("GestionDeStockBean rechercherProduit en cours...");
		Produit myproduit = em.find(Produit.class, ref_produit);
		System.out.println("myproduit a été trouvé, c'est le : " + myproduit);			
		return myproduit;
		
	}
	
	public Commande getCommande(int no_commande) {
		System.out.println("Finding commande in progress...");
		Commande commande = em.find(Commande.class, no_commande);
		System.out.println("La commande trouvée est : "
				+ commande.getNumeroCommande());
		System.out.println("getCommande done");
		return commande;
	}
}
