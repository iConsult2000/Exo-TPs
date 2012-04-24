/**
 * 
 */


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bookshop.stateful.ShoppingCartBeanRemote;

/**
 * @author sdacalor
 * 
 */
public class ClientBookShopEffacerLigneCommande {

	/**
	 * @param args
	 */
	public static void main(int args) {
		try {
			Context context = new InitialContext();


		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
