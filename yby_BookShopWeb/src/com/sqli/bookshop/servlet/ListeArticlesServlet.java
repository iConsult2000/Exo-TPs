package com.sqli.bookshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sqli.bookShop.facade.BookshopFacadeBeanLocal;
import com.sqli.bookShop.persistance.Article;

/**
 * Servlet implementation class ListeArticlesServlet
 */
public class ListeArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BookshopFacadeBeanLocal book_shop_facade_local;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeArticlesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Article> listeArt = (ArrayList<Article>) book_shop_facade_local.getAllArticles();
		
		HttpSession session = request.getSession();		
		session.setAttribute("lesArticles",listeArt);
		
		//redirection
		request.getRequestDispatcher("/").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
