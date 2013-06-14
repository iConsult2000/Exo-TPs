package com.sqli.bookshop.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
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
	
	@Resource(mappedName = "/queue/BookShopQueue")
	Queue queue;
	
	@Resource(mappedName = "ConnectionFactory")
	QueueConnectionFactory connectionFactory;

	QueueSession sessionQueue;
	QueueConnection connection;
	TextMessage message;
	MessageProducer messageProducer;
       
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
		
		//Ajout ligne de commande dans le panier
		if(action.equals("add")){
			cart_bean.addLigneCommande(numero);
			cde = cart_bean.getCommande();
			session.setAttribute("shoppingCart", cde);
			//redirection
			request.getRequestDispatcher("listeArticle.jsp").forward(request, response);
			
		//Suppression ligne de commande dans le panier	
		} else if (action.equals("del")) {
			cart_bean.removeLigneCommande(numero);
			cde = cart_bean.getCommande();
			session.setAttribute("shoppingCart", cde);
			//redirection
			request.getRequestDispatcher("listeArticle.jsp").forward(request, response);
		} else {
			//Validation du panier
			//Send message to MessageDriven			
			try {	
				//on crée un contexte
				InitialContext ctx = new InitialContext();
				//on récupère la queue
				Queue queue = (Queue) ctx.lookup("queue/BookShopQueue");
				//on recupère la connectionFactory
				connectionFactory = (QueueConnectionFactory) ctx.lookup("/ConnectionFactory");
				//on crée la connexion
				connection = (QueueConnection) connectionFactory.createConnection();
				//on crée une session pour se connecter a la queue
				sessionQueue = connection.createQueueSession(false, sessionQueue.AUTO_ACKNOWLEDGE);
				//on crée le message 
				message = sessionQueue.createTextMessage();
				message.setText("Commande Validée");
				//Là on crée un objet dans la session qui va nous permettre d'envoyer le message il y en a un autre qui s'appelle sender mais bon
				messageProducer = sessionQueue.createProducer(queue);
				//on envoit
				messageProducer.send(message);
			} catch (Exception e) {
				System.out.println("Le mesage n'a pas été envoyé!!!!!");
				e.printStackTrace();
			} finally {
				try {
					//on ferme la session
					sessionQueue.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					//on ferme la connexion vers la queue
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			cde = (Commande) session.getAttribute("shoppingCart");
			//Persist la commande
			cart_bean.validerAchat(cde);
			//Destruction du panier
			session.removeAttribute("shoppingCart");
			//redirection
			request.getRequestDispatcher("valider.jsp").forward(request, response);
			
		}//Fin valider cde

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
