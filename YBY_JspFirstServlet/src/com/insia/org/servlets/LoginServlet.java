package com.insia.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		Cookie[] mesCookies= request.getCookies(); // Je récupère tous les cookies
			if (mesCookies!=null)
			{
				for (int i=0; i<mesCookies.length; i++)
				{
					// S'ilexisteun Cookie nommé“nomCookie"
					if (mesCookies[i].getName().equals("nomCookie"))
					{
						// J’aitrouvéle cookie queje cherchais, j’affichesavaleur:
						System.out.println(mesCookies[i].getValue());
					}
				}
			}
		
		//Vérifie si le login à été saisi
		if  ( (login.equals("") )&& (pass.equals("")) ){//Vérif si vide
				response.getWriter().write("Le login est obligatoire et le mot de passe est obligatoire");
				//response.sendError(401, "Le login est obligatoire et le mot de passe est obligatoire");
			    return;
		}else{
			if(login.equals("boston") && pass.equals("boston")){//Vérif si correct
				//response.getWriter().write("Bienvenue Boston");
				response.setContentType("text/html");
				
				//Création de session
				HttpSession session = request.getSession();
				session.setAttribute("nom",login);
				session.setAttribute("pass",pass);
				session.setAttribute("ok","");
				
				//redirection
				RequestDispatcher dispatcher =null;
				dispatcher = request.getRequestDispatcher("/connexion.jsp");
				dispatcher.forward(request, response);
				
				//Gestion des cookies
				Cookie c = new Cookie("log",login );
				response.addCookie(c);
				
				
			}else{
				response.getWriter().write("Vérifier vos mot de passe");
			}
		} 
	}

}
