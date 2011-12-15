package org.insia.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.insia.beans.UserSession;
import org.insia.models.User;
import org.insia.utils.FakeDataHolder;

/**
 * Servlet implementation class MyServlet
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }
    
    /**
     * Traite les demandes de déconnexion
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getServletPath().equals("/logout")) {
    		request.getSession().invalidate();
    	}
    	request.getRequestDispatcher("/").forward(request, response);
    }
    
    /**
     * Traite les connexions
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FakeDataHolder database = FakeDataHolder.getInstance();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = (User) database.findOne("user",new String[]{"login", "password"}, new String[]{login, password});
		
		if(user != null) {
			HttpSession session = request.getSession(true);
			UserSession userSession = new UserSession();
			userSession.setUserLogged(user);
			session.setAttribute("userSession", userSession);
			response.sendRedirect("");
		} else {
			
		}
		
	}

}
