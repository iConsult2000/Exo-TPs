package com.sqli.bookshop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sqli.bookShop.facade.BookshopFacadeBeanLocal;
import com.sqli.bookShop.persistance.Article;

/**
 * Servlet implementation class AddArticleServlet
 */
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	BookshopFacadeBeanLocal book_bean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleServlet() {
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
		String filiere = request.getParameter("filiere");
		String libelle = request.getParameter("libelle");
		float prix = Float.parseFloat(request.getParameter("prix")) ;
		int qte = Integer.parseInt(request.getParameter("quantite")) ;
		String yes;

			Article a = new Article();
			a.setFiliere(filiere);
			a.setLibelle(libelle);
			a.setPrix(prix);
			a.setQuantite(qte);
			
			book_bean.addArticle(a);
			yes = a.getLibelle();
		
		HttpSession session = request.getSession();		
		session.setAttribute("art",yes);
		
		//redirection
		request.getRequestDispatcher("/article.jsp").forward(request, response);
		
		
	}

}
