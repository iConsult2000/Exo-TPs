package com.pizzeria.customer.action;

import java.util.Collection;
// Import log4j classes.
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.pizzeria.cart.model.Cart;
import com.pizzeria.customer.bo.CustomerBo;
import com.pizzeria.customer.model.Customer;
import com.pizzeria.pizza.model.Pizza;

public class CartAction extends ActionSupport{

    /* --------------- */
    /* -- CONSTANTES -- */
    /* --------------- */
	
	
	
    /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */
	 /**
     * Le logger de la classe.
     */
	// Define a static logger variable so that it references the
	   // Logger instance named "MyApp".
	   static Logger logger = Logger.getLogger(CartAction.class);

	
	
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

		logger.debug("Initialisation du titre de la page");
		CustomerBo customerBo =
				(CustomerBo) getWebApplicationContext().getBean("customerBo");

		logger.debug("Traitement du Panier en session");	
		HttpSession session = pRequest.getSession();
		Cart cart = (Cart) session.getAttribute("sessionCart");
			
			
			
		return pMapping.findForward("success");
	}
	
	/* 
     * Permet de passer à la commande.
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
	public ActionForward enregistrer(ActionMapping pMapping,ActionForm pForm,
			HttpServletRequest pRequest,HttpServletResponse pResponse) 
	        throws Exception {
	 
			
			
			
			
			return pMapping.findForward("success");
	}
	
	
	/*
	 * Méthode permettant de récupérer les pizzas sélectionnées
	 */
	public Collection<Pizza> getSelectedPizza(){
	
	return null;
	
	
	}
	
	/*
	 * Méthode permettant de récupérer les infos du user en cours
	 */
	public Customer getCustomerInfos(){
	
	return null;
	
	
	}
}
