package org.insia.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie[] mesCookies= request.getCookies(); // Je r�cup�re tous les cookies
		System.out.println(mesCookies[0].getName());
		
			for (int i=0; i < mesCookies.length; i++)
			{
				// S'il existeun Cookie nomm�nomCookie"
				if (mesCookies[i].getName().equals("logcookie1"))
				{
					// J�ai trouv�le cookie que je cherchais, j�affiche sa valeur:
					mesCookies[i].setMaxAge(0);
					response.addCookie(mesCookies[i]);
					break;

				}
				
			}
		response.sendRedirect("accueil.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


}
