package com.bookshop.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.facade.BookShopFacadeBeanLocal;
import com.bookshop.facade.BookShopFacadeBeanRemote;
import com.bookshop.models.Cart;
import com.bookshop.stateful.ShoppingCartBeanLocal;
import com.bookshop.stateful.ShoppingCartBeanRemote;

/**
 * Servlet implementation class AddArticleToShoppingCart
 */
public class AddArticleToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddArticleToShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Integer sessionCounterAA = (Integer) session
				.getAttribute("sessionCounterAA");

		if (sessionCounterAA == 0) {

			// Incremente la valeur du compteur pour ne plus passer ici
			session.setAttribute("counter", 1);

			// Sauvegarde de la ligne de commande
			int quantite = 1;
			int remise = 0;

			try {
				Context context = new InitialContext();
				System.out.println("Recherche de l’EJB");

				ShoppingCartBeanRemote shoppingcartbeanRemote = (ShoppingCartBeanRemote) context
						.lookup("SDR_BookShop/ShoppingCart/remote");

				BookShopFacadeBeanRemote beanfacadeRemote = (BookShopFacadeBeanRemote) context
						.lookup("SDR_BookShop/BookShopStateless/remote");

				shoppingcartbeanRemote.addLigneCommande(
						Integer.valueOf(request.getParameter("numeroArticle")),
						quantite, remise);

				// Recherche du produit

				((Cart) session.getAttribute("sessionCart"))
						.getListproduit()
						.add(beanfacadeRemote.rechercherProduit(Integer
								.valueOf(request.getParameter("numeroArticle"))));

				// Mise en session
				session.setAttribute("sessionshoppingcartbeanRemote",
						shoppingcartbeanRemote);
				session.setAttribute("sessionbeanfacadeRemote",
						beanfacadeRemote);

				
			} catch (NamingException e) {
				e.printStackTrace();
			}

		} else {

			// Sauvegarde de la ligne de commande
			int quantite = 1;
			int remise = 0;
			((ShoppingCartBeanLocal) session
					.getAttribute("sessionshoppingcartbeanRemote"))
					.addLigneCommande(Integer.valueOf(request
							.getParameter("numeroArticle")), quantite, remise);

			((Cart) session.getAttribute("sessionCart")).getListproduit().add(
					((BookShopFacadeBeanLocal) session
							.getAttribute("sessionbeanfacadeRemote"))
							.rechercherProduit(Integer.valueOf(request
									.getParameter("numeroArticle"))));

		}

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
