/**
 * 
 */
package org.insia.beans;

import java.util.List;


import org.insia.models.Product;
import org.insia.utils.FakeDataHolder;


/**
 * @author sdacalor
 *
 */
public class ProductContent {

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (List<Product>) database.get("Products"); 
	}
	
	public Product getProducts(String name) {
		FakeDataHolder database = FakeDataHolder.getInstance();
		return (Product) database.findOne("Products", "name", name);
	}
}
