/**
 * 
 */
package org.insia.models;

import java.io.Serializable;


/**
 * @author sdacalor
 *
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String item;
	private Integer prix;
	private String description;
	private String path_to_icon;
	
	
	public Product () {}
	
	public Product(String item, Integer prix, String description, String path_to_icon){
		this.item = item;
		this.prix = prix;
		this.description = description;
		this.path_to_icon = path_to_icon;
	}
	
	
	
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

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return path_to_icon;
	}

	
	
}
