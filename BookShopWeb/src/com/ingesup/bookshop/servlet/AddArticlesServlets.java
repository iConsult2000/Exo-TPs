package com.ingesup.bookshop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ingesup.bookshop.facade.BookShopFacadeBeanRemote;
import com.ingesup.bookshop.persistance.Article;

/**
 * Servlet implementation class AddArticlesServlets
 */
public class AddArticlesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB 
	BookShopFacadeBeanRemote bookShopFacadeBeanRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticlesServlets() {
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
		/*System.out.println("doPost");
		String libelle = request.getParameter("libelle");
		float prix = Float.parseFloat(request.getParameter("prix"));
		
		System.out.println("l'Article "+libelle+" à "+prix+"a été enregistré");
		
		Article a = new Article(libelle,prix);
		
		//bookShopFacadeBeanRemote.addArticle(a);
		
		System.out.println("l'Article "+libelle+" a bien été ajouté!");
		
		//redirection*/
		request.getRequestDispatcher("/").forward(request, response);
	}

}
