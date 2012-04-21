package com.ingesup.bookshop.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ingesup.bookshop.facade.BookShopFacadeBeanLocal;
import com.ingesup.bookshop.facade.BookShopFacadeBeanRemote;
import com.ingesup.bookshop.persistance.Article;

/**
 * Servlet implementation class ListeArticlesServlets
 */

public class ListeArticlesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BookShopFacadeBeanRemote  bookShopFacadeBeanRemote;
	/**
     * Default constructor. 
     */
    public ListeArticlesServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	HttpSession session = request.getSession(true);

    	Collection<Article> articles = bookShopFacadeBeanRemote.getAllArticles();
    	String listeLibelles = " ";
    	String listePrix = " ";
    	for(Article art : articles){
    	listeLibelles +=art.getLibelle().concat(" ");
    	listePrix +=Float.toString(art.getPrix()).concat(" ");
    	}
    	session.setAttribute("listeLibelles",listeLibelles);
    	session.setAttribute("listePrix",listePrix);

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
