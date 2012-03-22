package com.ingesup.bookshop.facade;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ingesup.bookshop.persistance.Article;
import com.ingesup.bookshop.utils.BookShopBouchon;

/**
 * Session Bean implementation class BookShopFacadeBean
 */
@Stateless
public class BookShopFacadeBean implements BookShopFacadeBeanRemote, BookShopFacadeBeanLocal {

	

	/**
     * Default constructor. 
     */
    public BookShopFacadeBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Collection<Article> getAllArticlesFromFilieres(String filiere){
		return null;}
    
    public Collection<Article> getAllArticles(){
		return BookShopBouchon.getAllArticles();
    }
    
    public void addArticle(Article article){}

}
