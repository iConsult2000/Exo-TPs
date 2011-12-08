/**
 * 
 */
package com.insia.org.servlets;

import java.io.Serializable;


/**
 * @author sdacalor
 *
 */
public class MyBeans {
	private static final long serialVersionUID = 1L;
	
	private String item;
	private Integer prix;
	private String description;
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
