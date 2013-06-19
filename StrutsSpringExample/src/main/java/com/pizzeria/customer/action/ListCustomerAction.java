package com.pizzeria.customer.action;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.web.struts.ActionSupport;

import com.pizzeria.cart.model.Cart;
import com.pizzeria.customer.bo.CustomerBo;
import com.pizzeria.customer.model.Customer;
 
public class ListCustomerAction extends ActionSupport{
 
	
    /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */
	 /**
     * Le logger de la classe.
     */
	// Define a static logger variable so that it references the
	   // Logger instance named "MyApp".
	  
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ListCustomerAction.class);
	
    /* --------------- */
    /* -- METHODES -- */
    /* --------------- */
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {
 
		logger.debug("Initialisation de la page d'accueil");
		CustomerBo customerBo =
			(CustomerBo) getWebApplicationContext().getBean("customerBo");
		
		DynaActionForm dynaCustomerListForm = (DynaActionForm)form;
		
		logger.debug("Récupération de la liste des Clients");
		List<Customer> list = customerBo.findAllCustomer();
		
		dynaCustomerListForm.set("customerList", list);
		
		/*
		 * Ajout d'une session pour gérer le Panier
		 */
		logger.debug("Mise en session du panier");
		HttpSession session = request.getSession();
		Cart cart = new Cart();
		String token = "invalide";
		
		session.setAttribute("sessionCart", cart);
		session.setAttribute("sessionToken", token);
	        
		return mapping.findForward("success");
	  
	}
 
}