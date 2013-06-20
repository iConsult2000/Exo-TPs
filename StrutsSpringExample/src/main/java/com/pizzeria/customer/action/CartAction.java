package com.pizzeria.customer.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.pizzeria.cart.model.Cart;
import com.pizzeria.customer.bo.CustomerBo;
import com.pizzeria.customer.model.Customer;
import com.pizzeria.pizza.bo.PizzaBo;
import com.pizzeria.pizza.model.Pizza;

public class CartAction extends ActionSupport{

	/* --------------- */
	/* -- CONSTANTES -- */
	/* --------------- */



	/* --------------- */
	/* -- ATTRIBUTS -- */
	/* --------------- */
	// Define a static logger variable so that it references the
	// Logger instance named "MyApp".
	Logger logger = LogManager.getLogger(CartAction.class.getName());



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
		String token = "valide";
		if (session.getAttribute("sessionToken") != null && ((String) session.getAttribute("sessionToken")).equals("invalide")){
			session.setAttribute("sessionToken", token);
		}

		logger.debug("Initialisation du titre de la page");
		CustomerBo customerBo =
				(CustomerBo) getWebApplicationContext().getBean("customerBo");

		logger.debug("Traitement du Panier en session");	
		session = pRequest.getSession();
		if (session != null) {
			Cart cart = (Cart) session.getAttribute("sessionCart");
			Collection<Pizza> myListPizza = (cart.getListproduit() != null ? cart.getListproduit() : new ArrayList<Pizza>());

			/* La recherche */
			String nameToFind = "Pizza" + pRequest.getParameter("nomArticle");

			/*Retrouvez la pizza et l'ajouter */
			PizzaBo pizzaBo =
					(PizzaBo) getWebApplicationContext().getBean("pizzaBo");
			for (Pizza p : pizzaBo.findAllPizza()){
				if (p.getNom().equals(pRequest.getParameter("nomArticle"))) {
					myListPizza.add(p);
				}
			}

			/*Affecter la nouvelle liste de pizza*/
			cart.setListproduit(myListPizza);

			/* Ajout de Pizza */
			session.setAttribute("sessionCart", cart);
			String sessionListPizza = "";
			session.setAttribute("sessionListPizza", myListPizza);
		}

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
