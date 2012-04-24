package com.bookshop.facade;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Local;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.Produit;

@Local
public interface BookShopFacadeBeanLocal {

	@PermitAll
	public List<Produit> getAllArticlesFromFiliere(String filiere);

	@PermitAll
	public List<Produit> getAllArticles();

	@PermitAll
	public void addArticle(Produit article);
	
	@PermitAll
	public Produit rechercherProduit(int ref_produit);
	
	@PermitAll
	public Commande getCommande(int no_commande);
}
