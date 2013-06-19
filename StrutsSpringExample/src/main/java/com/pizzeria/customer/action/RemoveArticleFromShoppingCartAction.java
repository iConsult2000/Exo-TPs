package com.pizzeria.customer.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;


import com.pizzeria.cart.model.Cart;
import com.pizzeria.pizza.model.Pizza;

public class RemoveArticleFromShoppingCartAction extends ActionSupport{
	 /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */
	 /**
     * Le logger de la classe.
     */
	// Define a static logger variable so that it references the
	   // Logger instance named "MyApp".
	  
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(RemoveArticleFromShoppingCartAction.class);
	
	 /* --------------- */
    /* -- METHODES -- */
    /* --------------- */
	/* 
     * Permet d'initialiser l'affichage de la page.
     * 
     * @param pMapping
     *            L'ActionMapping utilisé pour sélectionner cette instance de classe Action Struts
     *            (définie dans le struts-config.xml)
     * @param pForm
     *            Le formulaire associé à cette action.
     * @param pRequest
     *            La requête HTTP envoyée par le client et que nous sommes en train de traiter.
     * @param pResponse
     *            La réponse HTTP que nous sommes en train de créer.
     * @return L'ActionForward vers lequel l'action doit rediriger l'utilisateur, ou {@code null} si
     *         la réponse a été complétée.
     * @throws Exception
     *             En cas d'absence d'un élément
	 * (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 
	 */
	public ActionForward execute(ActionMapping pMapping,ActionForm pForm,
			HttpServletRequest pRequest,HttpServletResponse pResponse) 
	        throws Exception {
			
		HttpSession session = pRequest.getSession();
		
		logger.info("initialisation de l'action");
		logger.info("Article à supprimer : " + Integer.valueOf(pRequest.getParameter("numeroArticle")));
		
		
		
		//Supprimer le ligne de commande de la commande
			
				long idToremove = Integer.valueOf(pRequest.getParameter("numeroArticle"));
				Collection<Pizza> mylist = ((Cart) session.getAttribute("sessionCart")).getListproduit();
				
				for (Pizza e : mylist) {
					if (e.getPrix() == Integer.valueOf(pRequest.getParameter("numeroArticle"))) {
						if (mylist.remove(e)) {
							System.out.println("Operation done");
							break;
						} else {
							System.out.println("Operation cancelled..");
						}
					}
				}
				
				((Cart) session.getAttribute("sessionCart")).setListproduit(mylist);
				
				logger.info("Nombre d'articles du Panier après:" + ((Cart) session.getAttribute("sessionCart")).getNbrearticles());
				
				
				
		return pMapping.findForward("success");
	}
	
}
