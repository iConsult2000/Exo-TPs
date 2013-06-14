package com.sqli.bookShop.statefull;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionRolledbackException;
import javax.transaction.UserTransaction;

import com.sqli.bookShop.persistance.Article;
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
	
	private boolean instance = true;
	private Transaction tx = null;
	private SessionContext ejbContext;
	
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
		

//		//Gestion de la transaction				
//	    UserTransaction tx = ejbContext.getUserTransaction();
//	 			try {
//					tx.begin();
//					
//					tx.commit();
//					
//					//ut.rollback();
//					
//				} catch (NotSupportedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SystemException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SecurityException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalStateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (RollbackException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (HeuristicMixedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (HeuristicRollbackException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
					
						
						
		
			   
		
	}
	
	public void afterCompletion(boolean committed){
		
		System.out.println("afterCompletion: " + committed);

		
	}

	@Override
	public void afterBegin() throws EJBException, RemoteException {
		System.out.println("afterBegin() ");   

		
	}

	@Override
	public void beforeCompletion() throws EJBException, RemoteException {
		System.out.println("beforeCompletion() ");

		
	}
	
}
