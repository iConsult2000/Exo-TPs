package com.insia.org.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import org.apache.catalina.Session;

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
		// TODO Auto-generated method stub
		
		//1. r�cup�ration des param�tre de requ�te
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		if ((login == null) || (pwd == null)) {
            // Le parametre 'login' n'est pas present
			response.getWriter().println("Error login!");
        }else if ((login.equals(""))|| (pwd.equals(""))) {
            // Le parametre 'login' est present mais est vide
        	response.getWriter().println("Error login");
        }else if((pwd.equals("password"))){
        	
        //2. Cr�ation session Http � partir de l'Object Request
        	HttpSession session = request.getSession();
        	
        //3. Mise en attribut de session des param�tres de requ�te
        	session.setAttribute("login",login);
        	
	        //3.1. Cr�ation du cookie
	    	Cookie my_cookie = new Cookie("cookie_login", login);
	    	my_cookie.setMaxAge(30);
	    	
	    	//3.2. Ajout du cookie dans la reponse
	    	response.addCookie(my_cookie);
    	
    	//System.out.println(my_cookie.getValue());
    	
        //4.Redirection vers la JSP
        	RequestDispatcher dispacher = null;
        	dispacher = request.getRequestDispatcher("/accueil.jsp");
        	
        	dispacher.forward(request, response);

        }
		
	}

}
