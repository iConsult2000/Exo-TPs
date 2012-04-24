package com.bookshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.models.Cart;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// 2. Cr�ation Session Http � partir de l'objet Request
		HttpSession session = request.getSession();
		int counterAA = 0;
		int counterLA = 0;
		String scat = null;
		String search = null;
		Cart panier = new Cart();

			
			//3. Mise en attribut de session des param requetes
		session.setAttribute("sessionCounterAA", counterAA);
		session.setAttribute("sessionCounterLA", counterLA);
		session.setAttribute("sessionScat", scat);
		session.setAttribute("sessionSearch", search);
		session.setAttribute("sessionCart", panier);


			
			System.out.println("Vous etes loggé");

			// 4. Redirection vers JSP
			// 3. Initialisation du dispatcher
			
			//response.sendRedirect("url-pattern");
			response.sendRedirect("listeArticles");
			// Use dispatcher
//			request.getRequestDispatcher("/WEB-INF/listeArticles.jsp").forward(
//						request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {



		}
	
}
	



