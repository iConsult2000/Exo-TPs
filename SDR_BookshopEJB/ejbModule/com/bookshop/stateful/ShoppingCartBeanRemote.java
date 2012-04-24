package com.bookshop.stateful;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Remove;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.DetailsCommande;

@Remote
public interface ShoppingCartBeanRemote {
	
	public Commande getCommande(int no_commande);
	public Commande addCommande(Collection<DetailsCommande> listlignedecommande, String code_client);
	public void removeLigneCommande(int numeroArticle);
	public int validerAchat(String code_client);
	@Remove void checkout();
}
