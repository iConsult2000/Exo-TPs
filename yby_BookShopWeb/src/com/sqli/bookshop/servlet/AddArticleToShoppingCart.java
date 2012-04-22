package com.sqli.bookshop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sqli.bookShop.persistance.Article;
import com.sqli.bookShop.persistance.Commande;
import com.sqli.bookShop.statefull.ShoppingCartBeanLocal;


/**
 * Servlet implementation class AddArticleToShoppingCart
 */
public class AddArticleToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ShoppingCartBeanLocal cart_bean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleToShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numeroArticle = Integer.parseInt(request.getParameter("num")) ;
		cart_bean.addLigneCommande(numeroArticle);
		Commande cde = cart_bean.getCommande();
		
		HttpSession session = request.getSession();
		session.setAttribute("shoppingCart", cde);

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
