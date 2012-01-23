/**
 * 
 */
package org.insia.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.insia.models.Product;

/**
 * @author sdacalor
 *
 */
public class CartContent {

	private float amount;
	private Random id;
	private Integer size;
	private ArrayList<Product> mybag = new ArrayList<Product>() ;
	
	/***
	 * Constructor of new Cart
	 */
	public CartContent () {
		this.amount = 0;
		this.id = new Random();
		System.out.println("Adding a new cart " + this.id);
	}
	
	
	/**
	 * @return the amount
	 */
	public float getAmount() {
		this.amount = 0;		
		for (Product product : mybag) { 
		this.amount = this.amount + product.getPrix();
		}
		return this.amount;
	}
	
	

	/***
	 * add a product in the cart
	 */
	public void addProduct(Product item) {
		this.mybag.add(item);
		System.out.println("Adding new item to cart");
	}
	
	/***
	 * Retrieve the list of products
	 */
	public List<Product> getProduct() {
		if (this.mybag != null) {
			return this.mybag;
		}
		else return null;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Random id) {
		this.id = id;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		if (this.mybag != null) {	
			return this.mybag.size();
		}
		else
			return 0;
				
	}


	/**
	 * @return the id
	 */
	public Random getId() {
		return this.id;
	}

	
}
