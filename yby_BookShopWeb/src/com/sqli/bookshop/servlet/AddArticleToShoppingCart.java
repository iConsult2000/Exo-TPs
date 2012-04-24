package com.sqli.bookshop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String action = request.getParameter("action");
		int numero = Integer.parseInt(request.getParameter("num")) ;
		Commande cde = null;
		HttpSession session = request.getSession();
		
		if(action.equals("add")){
			cart_bean.addLigneCommande(numero);
			cde = cart_bean.getCommande();
			session.setAttribute("shoppingCart", cde);
		} else if (action.equals("del")) {
			cart_bean.removeLigneCommande(numero);
			cde = cart_bean.getCommande();
			session.setAttribute("shoppingCart", cde);
		} else {
			
			
			QueueConnectionFactory ConnectionFactory = (QueueConnectionFactory) jndiContext.lookup("java:comp/env/jms/MyQueueConnectionFactory");
			Queue queue = (Queue)jndiContext.lookup("java:comp/env/jms/QueueName");

			Connection connection = ConnectionFactory.createConnection();
			Session session_jms = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session_jms.createProducer(queue);
			TextMessage message = session_jms.createTextMessage("Commande confirmée");
			messageProducer.send(message);
			messageProducer.close();
			session_jms.close();
			connection.close();
			
			cde = (Commande) session.getAttribute("shoppingCart");
			cart_bean.validerAchat(cde);
			session.removeAttribute("shoppingCart");
			
		}

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
