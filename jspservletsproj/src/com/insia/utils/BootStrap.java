package com.insia.utils;

import javax.servlet.http.HttpServlet;

import com.insia.beans.MyBeans;
import com.insia.models.Articles;

import java.util.List;


public class BootStrap extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//private User dummyUser = new User("test", "test");
	
	public void init() {
		//createDummyUsers();
		createDummyApps();
	}
	
	/*@SuppressWarnings("unchecked")
	public void createDummyUsers(){
		FakeDataHolder database = FakeDataHolder.getInstance();
		List<User> users = (List<User>) database.createTable("user");
		
		users.add(dummyUser);
	}*/
	
	@SuppressWarnings("unchecked")
	public void createDummyApps(){
			FakeDataHolder db = FakeDataHolder.getInstance();
			List<Articles> liste_produit = (List<Articles>) db.createTable("produit");
			
				liste_produit.add(new Articles("Ipad",250,"Ipad.png"));
				liste_produit.add(new Articles("Samsung Note",250,"samsung-galaxy-note.jpg"));
				
			}
			

}

