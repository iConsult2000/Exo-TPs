package com.bookshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.facade.BookShopFacadeBeanLocal;
import com.bookshop.models.PurchaseOrder;
import com.bookshop.persistance.DetailsCommande;
import com.bookshop.persistance.Produit;
import com.bookshop.stateful.ShoppingCartBeanLocal;

/**
 * Servlet implementation class ValidateOrder
 */
public class ValidateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ShoppingCartBeanLocal shoppingcartbeanLocal;
	@EJB
	BookShopFacadeBeanLocal beanfacadeLocal;

	public final static String JNDI_FACTORY = "org.jboss.naming.NamingContextFactory";
	public final static String JMS_FACTORY = "BSCFactory";
	public final static String QUEUE = "/queue/BookShopQueue";
	public final static String JNP_URL="jnp://localhost:1099";

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static InitialContext getInitialContext(String url)
			throws NamingException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		// creation du bon de commande
		PurchaseOrder bondecommande = new PurchaseOrder();
		Collection<DetailsCommande> listlignedecommandes = new ArrayList<DetailsCommande>();
		Collection<Produit> listProduits = new ArrayList<Produit>();
		

		bondecommande.setNo_commande(((ShoppingCartBeanLocal) session
				.getAttribute("sessionshoppingcartbeanlocal"))
				.validerAchat(request.getParameter("codeclient")));

		
		
		listlignedecommandes = ((BookShopFacadeBeanLocal) session
				.getAttribute("sessionbeanfacadeLocal")).getCommande(
				bondecommande.getNo_commande()).getDetailsCommande();
		
		//Ajout de chaque produit a la liste du bon de commande
		for (DetailsCommande dc : listlignedecommandes) {
			
			listProduits.add(((BookShopFacadeBeanLocal) session
					.getAttribute("sessionbeanfacadeLocal"))
					.rechercherProduit(dc.getPk().getRef_produit()));
		}
		

		bondecommande.setListProduits(listProduits);
		
		session.setAttribute("sessionbondecommande", bondecommande);
		
		//Send message to MessageDriven
		InitialContext ctx;
		try {
			ctx = getInitialContext(JNP_URL);
		
		QueueConnectionFactory qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);
		QueueConnection qcon = qconFactory.createQueueConnection();
		QueueSession qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = (Queue) ctx.lookup(QUEUE);
		QueueSender qsender = qsession.createSender(queue);
		TextMessage msg = qsession.createTextMessage();
		qcon.start();
		msg.setText("Commande confirmée");
		qsender.send(msg);
		qsender.close();
		qsession.close();
		qcon.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Use dispatcher
					request.getRequestDispatcher("/WEB-INF/purchaseOrder.jsp").forward(
							request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
