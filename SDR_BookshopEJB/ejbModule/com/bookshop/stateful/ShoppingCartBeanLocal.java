package com.bookshop.stateful;
import javax.ejb.Local;

import com.bookshop.persistance.Commande;

@Local
public interface ShoppingCartBeanLocal {
	public Commande getCommande(int no_commande);
	public void addLigneCommande(int numeroProduit, int quantite, float...remise);
	public void removeLigneCommande(int numeroArticle);
	public int validerAchat(String code_client);
	void checkout();
}
