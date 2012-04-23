package com.sqli.bookShop.statefull;
import javax.ejb.Remote;

import com.sqli.bookShop.persistance.Commande;

@Remote
public interface ShoppingCartBeanRemote {

	public Commande getCommande();
	
	public void addLigneCommande(int numeroArticle);

	public void removeLigneCommande(int ligneCommande);
	
	public void validerAchat(Commande commande);

	
}
