package com.insia.utils;

import javax.servlet.http.HttpServlet;

import com.insia.beans.MyBeans;
import com.insia.org.servlets.FakeDataHolder;

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
			List<MyBeans> liste_produit = (List<MyBeans>) db.get("produit");
				
				MyBeans id0001 = new MyBeans("Ipad",250);
				MyBeans id0002 = new MyBeans("Samsung Note",250);
				
				liste_produit.add(id0001);
				liste_produit.add(id0002);
				
			}
			

}

