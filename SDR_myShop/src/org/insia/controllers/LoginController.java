package org.insia.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.insia.beans.CartContent;
import org.insia.models.Product;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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

		// 3.bis Utiliser un cookies
		// set a cookie

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = "";
		String passwd = "";
		

		// 2. Cr�ation Session Http � partir de l'objet Request
		HttpSession session = request.getSession();


			// 1. R�cup�ration param�tre de requete
			login = request.getParameter("myname");
			passwd = request.getParameter("mypwd");
			CartContent cart = new CartContent() ; 
			

			


			//3. Mise en attribut de session des param requetes
			session.setAttribute("login", login);
			session.setAttribute("cart", cart);


			//4. Je suis logg�


			Cookie c1 = new Cookie("logcookie1", login);
			c1.setMaxAge(30);
			response.addCookie(c1);



			System.out.println("Vous �tes logg� manuellement");

			// 4. Redirection vers JSP
			// 3. Initialisation du dispatcher
			
			response.sendRedirect("shopreal");

		}
	
}
	



