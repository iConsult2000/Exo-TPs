package com.ingesup.bookshop.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ingesup.bookshop.facade.BookShopFacadeBeanRemote;
import com.ingesup.bookshop.persistance.Article;

/**
 * Servlet implementation class ListeArticlesServlets
 */

public class ListeArticlesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB	BookShopFacadeBeanRemote bsfbr;
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
    	HttpSession session = request.getSession();
    	
    	Collection<Article> articles = bsfbr.getAllArticles();
    	
    	session.setAttribute("ListArticles", articles);
        
        
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
