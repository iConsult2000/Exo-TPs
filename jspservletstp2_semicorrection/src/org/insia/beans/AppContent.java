package org.insia.beans;

import java.util.List;

import org.insia.models.App;
import org.insia.utils.FakeDataHolder;

public class AppContent {
	@SuppressWarnings("unchecked")
	public List<App> getApps() {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (List<App>) database.get("app"); 
	}
	
	public App getApp(String name) {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (App) database.findOne("app", "name", name);
	}
}
