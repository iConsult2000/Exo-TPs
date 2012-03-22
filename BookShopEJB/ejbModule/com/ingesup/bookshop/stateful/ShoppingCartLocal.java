package com.ingesup.bookshop.stateful;
import javax.ejb.Local;

import com.ingesup.bookshop.persistance.Commande;

@Local
public interface ShoppingCartLocal {
	
	public Commande getCommande();
	
	public void setCommande(Commande commande);
	
	public void addLigneCommande(int numeroArticle);
    
	public void removeLingCommande(int numeroArticle);
    
	public void validerAchat(Commande commande);

}
