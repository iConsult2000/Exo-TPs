package org.insia.models;

import java.io.Serializable;

public class App implements Serializable {
	private static final long serialVersionUID = -3050925805619707927L;
	
	private String name;
	private String description;
	private String icon;
	private Float price = 0.0f;
	private User creator;
	
	public App() {
		
	}
	
	public App(String name, float price, String description, User creator) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.creator = creator;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
