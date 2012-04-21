package com.ingesup.bookshop.stateful;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ingesup.bookshop.persistance.Commande;

/**
 * Session Bean implementation class ShoppingCart
 */
@Stateful
public class ShoppingCart implements ShoppingCartRemote, ShoppingCartLocal {
	Commande commande;


    /**
     * Default constructor. 
     */
    public ShoppingCart() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void initialize(){
    	commande = new Commande();
    }

	/**
	 * @return the commande
	 */
	public Commande getCommande() {
		System.out.println("Passage dans la méthode getCommande");
		return commande;
	}

	/**
	 * @param commande the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public void addLigneCommande(int numeroArticle){
		
	}
    
	public void removeLingCommande(int numeroArticle){
		
	}
    
	public void validerAchat(Commande commande){
		
	}

}
