package com.insia.org.controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		//Verification login 
		if((login.equals(""))||(pass.equals(""))){
				response.getWriter().write("Veuillez entrez correctement votre login et/ou mot de passe");
				
			   // return;
		}
		else if(login.equals("Julien") && pass.equals("Julien")){
		
				response.setContentType("text/html");

				//Creation de session
				HttpSession session = request.getSession();
				session.setAttribute("nom",login);
				session.setAttribute("pass",pass);
				session.setAttribute("ok","");

				//redirection
				request.getRequestDispatcher("/connexion.jsp").forward(request, response);

		}
		else response.getWriter().write("Verifier vos mot de passe");
		} 
}

