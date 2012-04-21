package com.ingesup.bookshop.stateful;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ingesup.bookshop.persistance.Article;
import com.ingesup.bookshop.persistance.Commande;
import com.ingesup.bookshop.persistance.LigneDeCommande;

/**
 * Session Bean implementation class ShoppingCart
 */
@Stateful
public class ShoppingCart implements ShoppingCartRemote, ShoppingCartLocal {
	Commande commande;
	
	@PersistenceContext EntityManager em;

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
		if (commande.getLigneDeCommande() == null){
			commande.setLigneDeCommande(new ArrayList<LigneDeCommande>());
		}
		LigneDeCommande ligne = new LigneDeCommande();
		Article a = new Article();
		a.setNumeroArticle(numeroArticle);
		ligne.setArticle(a);
		em.persist(ligne);
		commande.getLigneDeCommande().add(ligne);
	}
    
	public void removeLingCommande(int numeroArticle){
		
	}
    
	public void validerAchat(Commande commande){
		em.persist(commande);
	}

}
