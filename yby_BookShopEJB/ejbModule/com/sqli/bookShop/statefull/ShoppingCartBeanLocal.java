package com.sqli.bookShop.statefull;
import javax.ejb.Local;

import com.sqli.bookShop.persistance.Commande;

@Local
public interface ShoppingCartBeanLocal {

	public Commande getCommande();
	
	public void addLigneCommande(int numeroArticle);

	public void removeLigneCommande(int numeroArticle);
	
	public void validerAchat(Commande commande);
	
}
