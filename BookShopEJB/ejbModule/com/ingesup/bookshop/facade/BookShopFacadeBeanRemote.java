package com.ingesup.bookshop.facade;
import java.util.Collection;

import javax.ejb.Remote;

import com.ingesup.bookshop.persistance.Article;

@Remote
public interface BookShopFacadeBeanRemote {
    
    public Collection<Article> getAllArticlesFromFilieres(String filiere);
    
    public Collection<Article> getAllArticles();
    
    public void addArticle(Article article);

}
