package com.sqli.bookShop.statefull;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

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
public class ShoppingCartBean implements SessionSynchronization {

	private Commande commande=null;

	@PersistenceContext(unitName="bookShopUnit")
	protected EntityManager em;
	public boolean instance = true;
				   
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
		//Vérifie si commande exist
		if (instance == false){
			commande = new Commande();
			instance = true;
			
		}
		boolean exist = false;
		System.out.println("Passage dans la méthode addLigneCommande()");
		ArrayList<LigneDeCommande> lignList = (ArrayList<LigneDeCommande>) commande.getLignesDeCommande();
		for(int i=0;i< lignList.size();i++ ){
			//Vérifie si la ligne exit avec ce num article 
			if(lignList.get(i).getArticle().getNumeroArticle() == numeroArticle){
				exist = true;
				//incrémente la quantité
				lignList.get(i).setQuantite(lignList.get(i).getQuantite()+1);
				//update in database
				em.merge(lignList.get(i));
				commande.setLignesDeCommande(lignList);
			}
		} 
		if(!exist){
			Article a = new Article();
			a.setNumeroArticle(numeroArticle);
			LigneDeCommande ligne = new LigneDeCommande();
			ligne.setArticle(a);
			ligne.setQuantite(1);
			em.persist(ligne);
			commande.getLignesDeCommande().add(ligne);
		}
	}

	public void removeLigneCommande(int ligneCommande) {
		ArrayList<LigneDeCommande> lignList = (ArrayList<LigneDeCommande>) commande.getLignesDeCommande();
		for (int i=0;i < lignList.size();i++){
			if (lignList.get(i).getIdLigneDeCommande() == ligneCommande){
				//Suppression List pour la session 
				lignList.remove(i);
				LigneDeCommande l = em.find(LigneDeCommande.class, ligneCommande);
				//Suppression en base
		        em.remove(l);
				System.out.println("removeLigneCommande()");
			}
		}
		commande.setLignesDeCommande(lignList);
	}

	public void validerAchat(Commande commande) {
		System.out.println("Passage dans la méthode validerAchat()");
		ArrayList<LigneDeCommande> ligneList = (ArrayList<LigneDeCommande>) commande.getLignesDeCommande();
		for (int i =0; i< commande.getLignesDeCommande().size();i++){
			//Attache before persist or merge
			Commande cde = new Commande();
			cde.setNumeroCommande(commande.getNumeroCommande());
			ligneList.get(i).setCommande(cde);
			em.merge(ligneList.get(i));
		}
		em.persist(commande);
		instance = false;
		
//		Context context = new InitialContext();
//		ShoppingCartBeanRemote bsfRemote = (ShoppingCartBeanRemote) context.lookup("Ingesup/ShoppingCart/remote");
//		   
//		UserTransaction ut = (UserTransaction) context.getUserTransaction();
//
//		   try {
//		      ut.begin();
//
//		      ut.commit();
//		   } catch (Exception ex) {
//		       try {
//		          ut.rollback();
//		       } catch (SystemException syex) {
//		           throw new EJBException
//		              ("Rollback failed: " + syex.getMessage());
//		       }
//		       throw new EJBException 
//		          ("Transaction failed: " + ex.getMessage());
//		    }
		
	}
	
	public void afterCompletion(boolean committed){
//		  System.out.println("afterCompletion: " + committed);
//		   if (committed == false) {
//		      try {
//		         checkingBalance = selectChecking();
//		         savingBalance = selectSaving();
//		      } catch (SQLException ex) {
//		          throw new EJBException("afterCompletion SQLException: " + ex.getMessage());
//		      }
//		   }
	}

	@Override
	public void afterBegin() throws EJBException, RemoteException {
		   
//		System.out.println("afterBegin()");
//		   try {
//		      checkingBalance = selectChecking();
//		      savingBalance = selectSaving();
//		   } catch (SQLException ex) {
//		       throw new EJBException("afterBegin Exception: " +
//		           ex.getMessage());
//		   }
		
	}

	@Override
	public void beforeCompletion() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}
}
