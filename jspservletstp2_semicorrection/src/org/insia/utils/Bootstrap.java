package org.insia.utils;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.insia.models.App;
import org.insia.models.User;
import org.insia.utils.FakeDataHolder;

public class Bootstrap extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private User dummyUser = new User("test", "test");
	
	public void init() {
		createDummyUsers();
		createDummyApps();
	}
	
	@SuppressWarnings("unchecked")
	public void createDummyUsers(){
		FakeDataHolder database = FakeDataHolder.getInstance();
		List<User> users = (List<User>) database.createTable("user");
		
		users.add(dummyUser);
	}
	
	@SuppressWarnings("unchecked")
	public void createDummyApps(){
		FakeDataHolder database = FakeDataHolder.getInstance();
		List<App> apps = (List<App>) database.createTable("app");
		
		apps.add(new App("MyExpensiveApp", 250.0f, "Une application génialissime", dummyUser));
		apps.add(new App("MyApp 2", 10.0f, "Une application génialissime 2", dummyUser));
		apps.add(new App("CoolApp", 0.20f, "Une application génialissime 3", dummyUser));
		apps.add(new App("iDroid Map 7", 2.0f, "Navigation!", dummyUser));
		apps.add(new App("gmel", 0.0f, "Accédez a vos emails !", dummyUser));
		apps.add(new App("uselessApp", 0.0f, "Elle sert à rien !", dummyUser));
	}
}
