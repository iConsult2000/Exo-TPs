package com.bookshop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.facade.BookShopFacadeBean;
import com.bookshop.facade.BookShopFacadeBeanLocal;
import com.bookshop.models.Cart;
import com.bookshop.persistance.DetailsCommande;
import com.bookshop.persistance.DetailsCommandePK;
import com.bookshop.persistance.Produit;
import com.bookshop.stateful.ShoppingCartBeanLocal;

/**
 * Servlet implementation class AddArticleToShoppingCart
 */
public class AddArticleToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB ShoppingCartBeanLocal shoppingcartbeanLocal;
	@EJB BookShopFacadeBeanLocal beanfacadeLocal;

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
			shoppingcartbeanLocal.addLigneCommande(
					Integer.valueOf(request.getParameter("numeroArticle")),
					quantite, remise);

			// Recherche du produit

			

			((Cart) session.getAttribute("sessionCart")).getListproduit().add(
					beanfacadeLocal.rechercherProduit(Integer
							.valueOf(request.getParameter("numeroArticle"))));

			// Mise en session
			session.setAttribute("sessionshoppingcartbeanlocal",
					shoppingcartbeanLocal);
			session.setAttribute("sessionbeanfacadeLocal", beanfacadeLocal);

			// Use dispatcher
			request.getRequestDispatcher("/WEB-INF/commande.jsp").forward(
					request, response);

		} else {

			// Sauvegarde de la ligne de commande
			int quantite = 1;
			int remise = 0;
			((ShoppingCartBeanLocal) session
					.getAttribute("sessionshoppingcartbeanLocal")).addLigneCommande(
							Integer.valueOf(request.getParameter("numeroArticle")),
							quantite, remise);
								

			((Cart) session.getAttribute("sessionCart")).getListproduit().add(
					((BookShopFacadeBeanLocal) session
							.getAttribute("sessionbeanfacadeLocal"))
							.rechercherProduit(Integer.valueOf(request
									.getParameter("numeroArticle"))));
			

			
			// Use dispatcher
			request.getRequestDispatcher("/WEB-INF/commande.jsp").forward(
					request, response);
		}

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
