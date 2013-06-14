package com.bookshop.servlet;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.facade.BookShopFacadeBeanRemote;
import com.bookshop.models.StoreMag;

/**
 * Servlet implementation class ListeArticlesServlet
 */

public class ListeArticlesServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeArticlesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// INITIALISATION DES VARIABLES
		HttpSession session = request.getSession();

		int counterLA = (Integer) session.getAttribute("sessionCounterLA");
		System.out.println("counterLA is: " + counterLA);
		if (counterLA == 0) {
			StoreMag stock = new StoreMag();

			try {
				Context context = new InitialContext();
				System.out.println("Recherche de l’EJB");

				BookShopFacadeBeanRemote beanfacadeRemote = (BookShopFacadeBeanRemote) context
						.lookup("SDR_Bookshop/BookShopStateless/remote");

				// Recuperation de la liste
				stock.addStore(beanfacadeRemote.getAllArticles());

				// session sharing
				session.setAttribute("sessionStock", stock);
				session.setAttribute("sessionCounterLA", 1);
			} catch (NamingException e) {
				e.printStackTrace();
			}

		} else {

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
