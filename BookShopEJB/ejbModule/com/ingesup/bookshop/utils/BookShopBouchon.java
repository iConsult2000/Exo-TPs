package com.ingesup.bookshop.utils;

import java.util.ArrayList;
import java.util.Collection;

import com.ingesup.bookshop.persistance.Article;

public class BookShopBouchon {
	
	private Collection<Article> Articles; 
	
	public BookShopBouchon(){
		
		/*
		 * Creation d'articles
		 */
		Article art1 = new Article(01,"Watch FESTINA",120.0f);
		Article art2 = new Article(02,"New Ipad 3",500.0f);
		Article art3 = new Article(03,"SAMSUNG Galaxy SII",499.0f);
		Article art4 = new Article(04,"Western Digital",90.0f);
		
		/*
		 * Creation de la collection
		 */
		this.Articles= new ArrayList<Article>();
		
		/*
		 * Ajout des articles dans la collection
		 */
		Articles.add(art1);
		Articles.add(art2);
		Articles.add(art3);
		Articles.add(art4);
	}

	public static Collection<Article> getAllArticles() {
		// TODO Auto-generated method stub
		BookShopBouchon bsb = new BookShopBouchon();
		return bsb.Articles;
	}

}
