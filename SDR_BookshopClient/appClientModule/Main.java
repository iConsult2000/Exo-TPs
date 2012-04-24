import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static private void menu() throws IOException {
		String choice;
		
		System.out.println("----MENU-----");
		System.out.println("0-AjouterCommande");
		System.out.println("1-ListerTousLesProduits");
		System.out.println("2-ModifierCommande");
		System.out.println("3-RechercheCommande");
		System.out.println("Choisissez une opération :");
		choice = (new BufferedReader(new InputStreamReader(System.in)))
				.readLine();
		
		switch (Integer.valueOf(choice)) {
		case 0:
			ClientBookshopAjouterLigneCommande.main(0);
			menu();
		case 1:
			ClientBookShopListerTousLesProduits.main(0);
			menu();
		case 2:
			ClientBookshopModifierCommande.main(0);
			menu();
		case 3:
			ClientBookShopRechercheCommande.main(0);							
			menu();
		case 4:
			break;
		default:
			break;
		}					
	
	}
	
	
	public static void main(String[] args) {
		
		// Effectuer les appels de services souhaités					
		
		try {
			menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
	

}