package com.sqli.bookShop.persistance;

import java.util.ArrayList;
import java.util.Collection;


public class BookshopBouchon {

	private BookshopBouchon() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private BookshopBouchon instance;
	
	public synchronized BookshopBouchon getInstance() {
		if (instance == null){
			instance = new BookshopBouchon();
			init();
		}
		return instance;
	}
	
	private static Collection<Article> articles = new ArrayList<Article>();
	

	private static void init(){
		Article a = new Article();
		a.setNumeroArticle(1);
		a.setLibelle("JBOSS ear");
		a.setFiliere("livre");
		a.setPrix(12);
		articles.add(a);
		
		Article b = new Article();
		b.setNumeroArticle(2);
		b.setFiliere("livre");
		a.setLibelle("Mme Boulot Hachette");
		b.setPrix(15);
		articles.add(b);
		
		Article c = new Article();
		c.setNumeroArticle(3);
		c.setFiliere("Jeu/Jouet");
		a.setLibelle("Ballon de foot");
		c.setPrix(8);
		articles.add(c);
	}
	
	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public static Collection<Article> getAllArticles() {
		init();
		return articles;
	}

	
	public static Collection<Article> getAllArticlesFromFiliere(String filiere){
		init();
		ArrayList<Article> retour = new ArrayList<Article>();
		
		Collection<Article> liste = articles;
		for (Article a : liste){
			if (a.getFiliere() != null && a.getFiliere().equalsIgnoreCase(filiere)){
				retour.add(a);
			}
		}
		return retour;
	}
	

	public static void addArticle(Article a){
		articles.add(a);
	}
	
	
	public static Commande getCommande(){
		System.out.println("methode getCommande");
		return new Commande();
	}
	
	public static void addLigneCommande(int numeroArticle) {
		System.out.println("methode addLigneCommande");
	}

	public static void removeLigneCommande(int numeroArticle){
		System.out.println("methode removeLigneCommande");
	}
	
	public static void validerAchat(Commande commande){
		System.out.println("methode validerAchat");
	}
	
}
