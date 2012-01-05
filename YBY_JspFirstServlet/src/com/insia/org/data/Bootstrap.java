package com.insia.org.data;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.insia.org.models.Article;
import com.insia.org.models.cart;

public class Bootstrap extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//private User dummyUser = new User("test", "test");
	
	public void init() {
		createDummyUsers();
		createDummyApps();
	}
	
	@SuppressWarnings("unchecked")
	public void createDummyUsers(){
		FakeDataHolder database = FakeDataHolder.getInstance();
		//List<User> users = (List<User>) database.createTable("user");
		
		//users.add(dummyUser);
	}
	
	@SuppressWarnings("unchecked")
	public void createDummyApps(){
		FakeDataHolder database = FakeDataHolder.getInstance();
		List<Article> apps = (List<Article>) database.createTable("article");
		
		apps.add(new Article("Rollex 9800 v", 1349.0f, "Une montre de luxe, fonctionne sans pile et étanche jusqu'a 1000m de profondeur","Montre Rollex"));
		apps.add(new Article("Map nav 7", 5.0f, "Une application génialissime de navigation","Application iphone"));
		apps.add(new Article("Nokia 800", 107.20f, "Une application gnialissime 3", "Telephone Portable Nokia"));
		apps.add(new Article("Lacoste sac", 80.0f, "Sac à main", "Sac à main"));
		apps.add(new Article("Galaxy note", 499.99f, "Mi smartphone, mi tablette, la puissance de la technologie", "Telephone Portable Samsung"));
		
		System.out.print("Booststrap démarré, artciles done !");
		//Instanciation Pannier
		//ArrayList<cart> listcart = new ArrayList();
		//listcart = null;
	}
	
	
}
