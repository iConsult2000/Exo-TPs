package com.ingesup.bookshop.stateful;
import javax.ejb.Remote;

import com.ingesup.bookshop.persistance.Commande;

@Remote
public interface ShoppingCartRemote {
	
	public Commande getCommande();
	
	public void setCommande(Commande commande);
	
	public void addLigneCommande(int numeroArticle);
    
	public void removeLingCommande(int numeroArticle);
    
	public void validerAchat(Commande commande);

}
