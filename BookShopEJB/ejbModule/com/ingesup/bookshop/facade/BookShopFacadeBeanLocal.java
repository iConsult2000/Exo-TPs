package com.ingesup.bookshop.facade;
import java.util.Collection;

import javax.ejb.Local;

import com.ingesup.bookshop.persistance.Article;

@Local
public interface BookShopFacadeBeanLocal {
    
    public Collection<Article> getAllArticlesFromFilieres(String filiere);
    
    public Collection<Article> getAllArticles();
    
    public void addArticle(Article article);
    
}
