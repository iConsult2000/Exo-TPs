import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ingesup.bookshop.stateful.ShoppingCartRemote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BookShopClientMain {

	public BookShopClientMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		try {
			
		InitialContext context = new InitialContext();
		
		ShoppingCartRemote beanRemote = (ShoppingCartRemote) context.lookup("BookShop/ShoppingCartRemote/remote");
		
		System.out.println("Bonjour Client!\n");
		
		
		System.out.println("\n-----Menu-----\n");
		System.out.println("1-----Ajouter un article-----\n");
		System.out.println("2-----Afficher les articles-----\n");
		String choix = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		switch (Integer.valueOf(choix)){
		case 2:	/*System.out.println("\nListe des produits :\n");
				Collection<Article> articles 	= beanRemote.getAllArticles();
				String listeLibelles			= "";
				for(Article art : articles){
					listeLibelles	+=("¤ ").concat(art.getLibelle()).concat("\n");
				}
				System.out.println(listeLibelles);*/
				break;
		case 3: beanRemote.getCommande();
				break;
		default :	break;
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
