package com.sqli.bookShop.facade;

import java.util.Collection;

import javax.ejb.Local;

import com.sqli.bookShop.persistance.Article;


@Local
public interface BookshopFacadeBeanLocal {
	
	public Collection<Article> getAllArticles();
	
	public Collection<Article> getAllArticlesFromFiliere(String filiere);
	
	public void addArticle(Article a);
	
}
