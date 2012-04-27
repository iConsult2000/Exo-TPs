package com.bookshop.stateful;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.DetailsCommande;

@Remote
public interface ShoppingCartBeanRemote {
	
	public Commande getCommande(int no_commande);
	public Commande addCommande(Collection<DetailsCommande> listlignedecommande, String code_client);
	
	public void addLigneCommande(int numeroProduit, int quantite, float...remise);
	public void removeLigneCommande(int numeroArticle);
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int validerAchat(String code_client);
	
	@Remove void checkout();
}




