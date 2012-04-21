package com.sqli.bookShop.facade;

import java.util.Collection;

import javax.ejb.Remote;

import com.sqli.bookShop.persistance.Article;


@Remote
public interface BookshopFacadeBeanRemote {

	public Collection<Article> getAllArticles();
	
	public Collection<Article> getAllArticlesFromFiliere(String filiere);
	
	public void addArticle(Article a);

	
}
