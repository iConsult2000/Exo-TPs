package com.insia.beans;

import java.util.List;

import com.insia.models.Articles;
import com.insia.utils.FakeDataHolder;

public class articleContent {
	@SuppressWarnings("unchecked")
	public List<Articles> getArticles() {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (List<Articles>) database.get("produit"); 
	}
	
	public Articles getArticle(String name) {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (Articles) database.findOne("produit", "ref", name);
	}
}
