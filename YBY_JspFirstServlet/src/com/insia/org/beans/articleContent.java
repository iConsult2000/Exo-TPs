package com.insia.org.beans;

import java.util.List;

import com.insia.org.models.Article;
import com.insia.org.data.FakeDataHolder;

public class articleContent {
	@SuppressWarnings("unchecked")
	public List<Article> getArticles() {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (List<Article>) database.get("article"); 
	}
	
	public Article getArticle(String name) {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (Article) database.findOne("article", "ref", name);
	}
}
