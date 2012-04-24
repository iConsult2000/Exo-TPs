/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bookshop.persistance.Commande;
import com.bookshop.persistance.DetailsCommande;
import com.bookshop.stateful.ShoppingCartBeanRemote;

/**
 * @author sdacalor
 * 
 */
public class ClientBookShopRechercheCommande {

	/**
	 * @param args
	 */
	public static void main(int args) {
		try {
			Context context = new InitialContext();

			// Utilisation d'un produit de test
			System.out.println("Entre le numero de commande : ");
			String no_commande = (new BufferedReader(new InputStreamReader(
					System.in))).readLine();

			ShoppingCartBeanRemote beanRemote = (ShoppingCartBeanRemote) context.lookup("BookShop/ShoppingCart/remote");

			// Appel de getCommande
			Commande mycom = beanRemote.getCommande(Integer.valueOf(no_commande));
			System.out.println("Numero_commande : "	+ mycom.getNumeroCommande()
					+ ", Code_Client : "+ mycom.getCode_client()
					+ ", Date :"+ mycom.getDate_commande());
			
			
			System.out.println("Affiche jour "+ mycom.getDate_commande().getDay());
			System.out.println("Affiche mois "+ mycom.getDate_commande().getMonth());
			
			int count =1;
			for (DetailsCommande eachline : mycom.getDetailsCommande()) {
				System.out.println("Article n° "+ count +System.getProperty("line.separator") 
						+ "NomProduit : " + eachline.getPk().getRef_produit() + ", "+ System.getProperty("line.separator")
						+ "Prix unitaire : "+ eachline.getPrix_unitaire()+ System.getProperty("line.separator")
						+ "Quantite : " + eachline.getQuantite() + System.getProperty("line.separator")
						+ "Remise : " + eachline.getRemise());
				count++;
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
