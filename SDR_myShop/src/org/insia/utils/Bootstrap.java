/**
 * 
 */
package org.insia.utils;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.insia.models.MyBeans;

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
		List<MyBeans> storeProducts = (List<MyBeans>) database.createTable("Products");
	
		
		MyBeans id001 = new MyBeans("id001", 250, "iPhone 4S");
		MyBeans id002 = new MyBeans("id002", 745, "Black Berry Curve");
		MyBeans id003 = new MyBeans("id003", 15, "Galaxy note");
		MyBeans id004 = new MyBeans("id004", 5, "nokia 800");
		MyBeans id005 = new MyBeans("id005", 75, "wave3 desire");
		
		//Add in database

		storeProducts.add(id001);
		storeProducts.add(id002);
		storeProducts.add(id003);
		storeProducts.add(id004);
		storeProducts.add(id005);
		
		//Verify information
		System.out.println("What is stored :");
		Iterator<MyBeans> e = storeProducts.iterator();
		while (e.hasNext()) {
			System.out.println(e.next());
		}
	}
}
