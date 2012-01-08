/**
 * 
 */
package org.insia.utils;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.insia.models.Product;

/**
 * @author sdacalor
 *
 */
public class Bootstrap extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void init() {
		createDummyProducts();
	}
	
	
	public void createDummyProducts(){
		FakeDataHolder database = FakeDataHolder.getInstance();
		
		//Completer la base de données Products
		@SuppressWarnings("unchecked")
		List<Product> storeProducts = (List<Product>) database.createTable("Products");
	
		
		Product id001 = new Product("id001", 250, "iPhone 4S", "Iphone_4_blanc_medium.png");
		Product id002 = new Product("id002", 745, "Black Berry Curve", "Curve-9360-front-medium.png");
		Product id003 = new Product("id003", 15, "Galaxy note", "samsung-galaxy-note-medium_front.png");
		Product id004 = new Product("id004", 5, "nokia 800", "nokia800-medium-front.png");
		Product id005 = new Product("id005", 75, "wave3 desire", "wave_3-medium-front.png");
		
		//Add in database

		storeProducts.add(id001);
		storeProducts.add(id002);
		storeProducts.add(id003);
		storeProducts.add(id004);
		storeProducts.add(id005);
		
		//Verify information
		System.out.println("What is stored :");
		Iterator<Product> e = storeProducts.iterator();
		while (e.hasNext()) {
			System.out.println(e.next());
		}
	}
}
