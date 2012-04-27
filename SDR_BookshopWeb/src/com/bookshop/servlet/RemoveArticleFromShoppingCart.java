package com.bookshop.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.models.Cart;
import com.bookshop.persistance.Produit;
import com.bookshop.stateful.ShoppingCartBeanRemote;

/**
 * Servlet implementation class RemoveArticleFromShoppingCart
 */
public class RemoveArticleFromShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveArticleFromShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		System.out.println("Article a supprimer : "
				+ Integer.valueOf(request.getParameter("numeroArticle")));

		//Supprimer le ligne de commande de la commande
		((ShoppingCartBeanRemote) session.getAttribute("sessionshoppingcartbeanRemote")).removeLigneCommande(Integer.valueOf(request.getParameter("numeroArticle")));
		
		System.out.println("Nombre d'articles du Panier avant :" + ((Cart) session.getAttribute("sessionCart")).getNbrearticles());
		
		//Supprimer le produit du panier
		Collection<Produit> mylist = ((Cart) session.getAttribute("sessionCart")).getListproduit();
		
		for (Produit e : mylist) {
			if (e.getRef_produit() == Integer.valueOf(request.getParameter("numeroArticle"))) {
				if (mylist.remove(e)) {
					System.out.println("Operation done");
					break;
				} else {
					System.out.println("Operation cancelled..");
				}
			}
		}
		((Cart) session.getAttribute("sessionCart")).setListproduit(mylist);
		
		System.out.println("Nombre d'articles du Panier après:" + ((Cart) session.getAttribute("sessionCart")).getNbrearticles());
				
		// Use dispatcher
		request.getRequestDispatcher("/WEB-INF/commande.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

	