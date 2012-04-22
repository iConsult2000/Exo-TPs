package com.ingesup.bookshop.facade;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ingesup.bookshop.persistance.Article;

/**
 * Session Bean implementation class BookShopFacadeBean
 */
@Stateless
public class BookShopFacadeBean implements BookShopFacadeBeanRemote, BookShopFacadeBeanLocal {

	@PersistenceContext EntityManager em;

	/**
     * Default constructor. 
     */
    public BookShopFacadeBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Collection<Article> getAllArticlesFromFilieres(String filiere){
		return null;}
    
    public Collection<Article> getAllArticles(){
    	/*System.out.println("lister tous les articles in progress...");
		javax.persistence.Query q = em.createQuery("select a from Article a");	
		System.out.println(q.getResultList().size()+" articles répertoriés");
		return (Collection<Article>) q.getResultList();*/
    	System.out.println("lister tous les articles in progress...");
    	System.out.println(em.createNamedQuery("findAllArticles").getResultList().size()+" articles répertoriés");
    	return em.createNamedQuery("findAllArticles").getResultList();
    }
    
    public void addArticle(Article article){
    	em.persist(article);    	
    }

}
