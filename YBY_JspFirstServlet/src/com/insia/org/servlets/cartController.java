package com.insia.org.servlets;

import com.insia.org.models.*;
import com.insia.org.beans.articleContent;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cartController
 */
@WebServlet("/cartController")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération variable GET url
		String action = request.getParameter("action");
		String ref = request.getParameter("name");
		//Ajout panier
		if(action.equals("addToCart")){
			
			//recherche article 
			articleContent search = new articleContent();
			//Instanciation de panier
			cart pan = new cart(search.getArticle(ref),1);
			
			//Création de session
			HttpSession session = request.getSession();
			
			//Vérifi si list panier vide
			if (session.getAttribute("cart") == null){
				//Création liste panier 
				ArrayList<cart> listcart = new ArrayList();
				session.setAttribute("cart",listcart);
				listcart.add(pan);
			}else{
				ArrayList<cart> listcart = (ArrayList<cart>)	session.getAttribute("cart");
				listcart.add(pan);
				session.setAttribute("cart",listcart);
			}

			//redirection
			request.getRequestDispatcher("/produit.jsp").forward(request, response);
		}//Fin addtocart
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
