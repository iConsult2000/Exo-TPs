
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bookshop.facade.BookShopFacadeBeanRemote;
import com.bookshop.persistance.Produit;
public class ClientBookShopListerTousLesProduits {

	/**
	 * @param args
	 */
	public static void main(int args) {
		try {
			Context context = new InitialContext();

			// Utilisation d'un produit de test
			System.out.println("Recupération de la liste des produits");

			BookShopFacadeBeanRemote beanRemote = (BookShopFacadeBeanRemote) context
					.lookup("BookShop/BookShopStateless/remote");

			List<Produit> myList = beanRemote.getAllArticles();

			for (Iterator<Produit> iter = myList.iterator(); iter.hasNext();) {
				Produit eachProduit = (Produit) iter.next();
				System.out.println(eachProduit.toString());
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
