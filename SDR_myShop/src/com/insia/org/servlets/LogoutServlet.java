package com.insia.org.servlets;

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
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie[] mesCookies= request.getCookies(); // Je récupère tous les cookies
		System.out.println(mesCookies[0].getName());
		
			for (int i=0; i < mesCookies.length; i++)
			{
				// S'il existeun Cookie nommé“nomCookie"
				if (mesCookies[i].getName().equals("logcookie1"))
				{
					// J’ai trouvéle cookie que je cherchais, j’affiche sa valeur:
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
