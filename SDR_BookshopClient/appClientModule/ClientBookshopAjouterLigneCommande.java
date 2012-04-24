import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bookshop.facade.BookShopFacadeBeanRemote;
import com.bookshop.persistance.Commande;
import com.bookshop.persistance.DetailsCommande;
import com.bookshop.persistance.DetailsCommandePK;
import com.bookshop.persistance.Produit;
import com.bookshop.stateful.ShoppingCartBeanRemote;

public class ClientBookshopAjouterLigneCommande {

	static Collection<DetailsCommande> listlignedecommande = new ArrayList<DetailsCommande>();

	static private DetailsCommande makeDetailsCommande() throws IOException {
		DetailsCommande lignedecommande = new DetailsCommande();
		DetailsCommandePK dcPK = new DetailsCommandePK();

		// Saisie de la reference
		System.out.println("Entre la ref du produit : ");
		String ref_produit = (new BufferedReader(new InputStreamReader(
				System.in))).readLine();

		dcPK.setRef_produit(Integer.valueOf(ref_produit));
		lignedecommande.setPk(dcPK);

		// Saisie de la quantite
		System.out.println("Saisir la quantite : ");
		String quantite = (new BufferedReader(new InputStreamReader(System.in)))
				.readLine();

		lignedecommande.setQuantite(Integer.valueOf(quantite));

		// Saisie de la remise
		System.out.println("Avez-vous une remise : oui/non ");
		String qRemise = (new BufferedReader(new InputStreamReader(System.in)))
				.readLine();

		if (qRemise.contains("oui")) {
			System.out.println("Saisir la remise :");
			String resRemise = (new BufferedReader(new InputStreamReader(
					System.in))).readLine();
			lignedecommande.setRemise(Integer.valueOf(resRemise));

		}

		// Recherche du produit
		try {
			Context context = new InitialContext();
			Produit produit = new Produit();
			BookShopFacadeBeanRemote bsfRemote = (BookShopFacadeBeanRemote) context
					.lookup("BookShop/BookShopStateless/remote");
			produit = bsfRemote.rechercherProduit(Integer.valueOf(ref_produit));
			lignedecommande.setPrix_unitaire(produit.getPrix_unitaire());

		} catch (NamingException e) {
			e.printStackTrace();
		}

		return lignedecommande;
	}

	static private Collection<DetailsCommande> prepareCommand()
			throws IOException {

		// Creation de la commande

		// Ajouter les ligne de commande
		menuLigne();

		System.out.println("Voici la commande :");

		for (DetailsCommande eachline : listlignedecommande) {
			System.out.println("Ref : " + eachline.getPk().getRef_produit()
					+ " , " + eachline.getPrix_unitaire() + "€ , quantite : "
					+ eachline.getQuantite());
		}

		System.out.println("Valider la commande oui/non :");
		String qValide = (new BufferedReader(new InputStreamReader(System.in)))
				.readLine();
		if (qValide == "oui") {

			return listlignedecommande;
		} else
			return null;
	}

	static private void menuLigne() throws IOException {
		String choice;

		System.out.println("----MENU-----");
		System.out.println("0-AjouterLigneCommande");
		System.out.println("1-EffacerLigneCommande");
		System.out.println("2-Continuer");
		choice = (new BufferedReader(new InputStreamReader(System.in)))
				.readLine();

		switch (Integer.valueOf(choice)) {
		case 0:
			listlignedecommande.add(makeDetailsCommande());

			menuLigne();
		default:
			break;
		}

	}

	public static void main(int args) {
		try {
			Context context = new InitialContext();

			System.out.println("Ajout d'un produit au panier");

			// Ajout dans le panier
			ShoppingCartBeanRemote beanRemote = (ShoppingCartBeanRemote) context
					.lookup("BookShop/ShoppingCart/remote");

			/**
			 * Il faut d'abord sauver le Detail Commande avant la commande
			 */
			try {
				// Saisie du code client
				System.out.println("Saisir le code Client (5 lettres) : ");
				String code_client = (new BufferedReader(new InputStreamReader(
						System.in))).readLine();

				prepareCommand();

				Commande mycom = beanRemote.addCommande(listlignedecommande,
						code_client);

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
							+ "Remise : " + eachline.getRemise() + System.getProperty("line.separator"));
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Utilisation d'un produit de test

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
