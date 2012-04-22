package com.sqli.bookShop.facade;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sqli.bookShop.persistance.Article;
import com.sqli.bookShop.persistance.BookshopBouchon;


/**
 * Session Bean implementation class BookshopFacadeBean
 */
@Stateless(name="BookShop", mappedName="BookShopFacade")
@Remote(BookshopFacadeBeanRemote.class)
@Local(BookshopFacadeBeanLocal.class)
public class BookshopFacadeBean {

	@PersistenceContext(unitName="bookShopUnit")
	protected EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BookshopFacadeBean() {
        // TODO Auto-generated constructor stub
    }

    public Collection<Article> getAllArticles(){
    	return em.createNamedQuery("findAllArticles").getResultList();
    }
	
	public Collection<Article> getAllArticlesFromFiliere(String filiere){
		return em.createNamedQuery("findAllArticleFromFiliere").setParameter("filiere", filiere).getResultList();
	}
	
	public void addArticle(Article a){
		em.persist(a);
	}
    
    
}

