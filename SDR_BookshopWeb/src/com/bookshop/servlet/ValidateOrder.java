package com.bookshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import javax.annotation.security.RolesAllowed;
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

import org.jboss.aspects.security.SecurityDomain;

import com.bookshop.facade.BookShopFacadeBeanRemote;
import com.bookshop.models.PurchaseOrder;
import com.bookshop.persistance.DetailsCommande;
import com.bookshop.persistance.Produit;
import com.bookshop.stateful.ShoppingCartBeanRemote;

/**
 * Servlet implementation class ValidateOrder
 */

public class ValidateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final static String JNDI_FACTORY = "org.jboss.naming.NamingContextFactory";
	public final static String JMS_FACTORY = "BSCFactory";
	public final static String QUEUE = "/queue/BookShopQueue";
	public final static String JNP_URL = "jnp://localhost:1099";

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

		// Initialiser la connection avec l’EJB Remote et la transaction

		try {
			Context ctx = getInitialContext(JNP_URL);
			

			// creation du bon de commande
			PurchaseOrder bondecommande = new PurchaseOrder();
			Collection<DetailsCommande> listlignedecommandes = new ArrayList<DetailsCommande>();
			Collection<Produit> listProduits = new ArrayList<Produit>();

			// Validation de la commande en transactionnel
			
			// Doing my business
			bondecommande.setNo_commande(((ShoppingCartBeanRemote) session
					.getAttribute("sessionshoppingcartbeanRemote"))
					.validerAchat(request.getParameter("codeclient")));

			

			// Recuperation de la commande persistée
			listlignedecommandes = ((BookShopFacadeBeanRemote) session
					.getAttribute("sessionbeanfacadeRemote")).getCommande(
					bondecommande.getNo_commande()).getDetailsCommande();

			// Ajout de chaque produit a la liste du bon de commande
			for (DetailsCommande dc : listlignedecommandes) {

				listProduits.add(((BookShopFacadeBeanRemote) session
						.getAttribute("sessionbeanfacadeRemote"))
						.rechercherProduit(dc.getPk().getRef_produit()));
			}

			bondecommande.setListProduits(listProduits);

			session.setAttribute("sessionbondecommande", bondecommande);

			String message = "LA COMMANDE " + bondecommande.getNo_commande()
					+ " EST CONFIRMEE";

			

			QueueConnectionFactory qconFactory = (QueueConnectionFactory) ctx
					.lookup(JMS_FACTORY);
			QueueConnection qcon = qconFactory.createQueueConnection();
			QueueSession qsession = qcon.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) ctx.lookup(QUEUE);
			QueueSender qsender = qsession.createSender(queue);
			TextMessage msg = qsession.createTextMessage();
			qcon.start();
			msg.setText(message);
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
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
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
