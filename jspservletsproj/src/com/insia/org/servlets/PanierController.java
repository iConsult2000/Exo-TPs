package com.insia.org.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.insia.models.Articles;
import com.insia.utils.FakeDataHolder;

import com.insia.beans.Panier;
import com.insia.beans.articleContent;

/**
 * Servlet implementation class PanierController
 */
@WebServlet("/PanierController")
public class PanierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String act = request.getParameter("action");
		String nom = request.getParameter("nom");
		
		if(act.equals("addToCart")){
			
			//Recherche de l'article
			FakeDataHolder db = FakeDataHolder.getInstance();
			
			//Création de session
			HttpSession session = request.getSession();
			
			if (session.getAttribute("login") != null) {
				Panier panier = (Panier) session.getAttribute("panier");
			

			Articles resultparamBean = (Articles) db.findOne("Articles", "item", request.getParameter("item"));

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
