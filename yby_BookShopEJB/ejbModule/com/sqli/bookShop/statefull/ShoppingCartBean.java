package com.sqli.bookShop.statefull;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sqli.bookShop.persistance.Article;
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
		System.out.println("Passage dans la méthode addLigneCommande()");
		Article a = new Article();
		a.setNumeroArticle(numeroArticle);
		LigneDeCommande ligne = new LigneDeCommande();
		ligne.setArticle(a);
		ligne.setQuantite(1);
		em.persist(ligne);
		commande.getLignesDeCommande().add(ligne);
	}

	public void removeLigneCommande(int ligneCommande) {
		ArrayList<LigneDeCommande> lignList = (ArrayList<LigneDeCommande>) commande.getLignesDeCommande();
		for (int i=0;i < lignList.size();i++){
			if (lignList.get(i).getIdLigneDeCommande() == ligneCommande){
				lignList.remove(i);
				LigneDeCommande l = em.find(LigneDeCommande.class, ligneCommande);
		        em.remove(l);
				System.out.println("removeLigneCommande()");
			}
		}
		commande.setLignesDeCommande(lignList);
	}

	public void validerAchat(Commande commande) {
		System.out.println("Passage dans la méthode validerAchat()");
		//em.persist(commande);
	}
    
}
