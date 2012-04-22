package com.sqli.bookShop.statefull;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sqli.bookShop.persistance.Article;
import com.sqli.bookShop.persistance.BookshopBouchon;
import com.sqli.bookShop.persistance.Commande;
import com.sqli.bookShop.persistance.LigneDeCommande;

/**
 * Session Bean implementation class ShoppingCartBean
 */
@Stateful(name="ShoppingCart", mappedName = "ShoppingCartBean")
@Local(ShoppingCartBeanLocal.class)
@Remote(ShoppingCartBeanRemote.class)
public class ShoppingCartBean{

	private Commande commande=null;

	@PersistenceContext(unitName="bookShopUnit")
	protected EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ShoppingCartBean() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void initialize(){
    	System.out.println("Methode initialise de ShoppingCartBean");
    	commande = new Commande();
    }

	public Commande getCommande() {
		System.out.println("Passage dans la méthode getCommande()");
		return commande;
	}

	public void addLigneCommande(int numeroArticle) {
		//Vérifie si la commande possède des Lignes de commande
		if (commande.getLignesDeCommande() == null){
			commande.setLignesDeCommande(new ArrayList<LigneDeCommande>());
		}
		System.out.println("Passage dans la méthode addLigneCommande()");
		LigneDeCommande ligne = new LigneDeCommande();
		Article a = new Article();
		a.setNumeroArticle(numeroArticle);
		ligne.setArticle(a);
		em.persist(ligne);
		commande.getLignesDeCommande().add(ligne);
		//BookshopBouchon.addLigneCommande(numeroArticle);
	}

	public void removeLigneCommande(int numeroArticle) {
		//@A faire
	}

	public void validerAchat(Commande commande) {
		em.persist(commande);
		//BookshopBouchon.validerAchat(commande);		
	}
    
}
