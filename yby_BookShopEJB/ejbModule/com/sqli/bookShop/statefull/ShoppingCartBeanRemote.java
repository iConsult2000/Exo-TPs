package com.sqli.bookShop.statefull;
import java.rmi.RemoteException;

import javax.ejb.Remote;


import com.sqli.bookShop.persistance.Commande;

@Remote
public interface ShoppingCartBeanRemote{

	public Commande getCommande();
	
	public void addLigneCommande(int numeroArticle);

	public void removeLigneCommande(int ligneCommande);
	
	public void validerAchat(Commande commande);
	
	public void afterCompletion(boolean committed) throws RemoteException;

	
}
