package com.bookshop.facade;
import java.util.Collection;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.Produit;

@Remote

public interface BookShopFacadeBeanRemote {
	@PermitAll
	public List<Produit> getAllArticles();
	
	@PermitAll
	public Produit rechercherProduit(int ref_produit);
	
	@PermitAll
	public List<Produit> getAllArticlesFromFiliere(String filiere);



	@PermitAll
	public void addArticle(Produit article);
	

	
	@PermitAll
	public Commande getCommande(int no_commande);
}
