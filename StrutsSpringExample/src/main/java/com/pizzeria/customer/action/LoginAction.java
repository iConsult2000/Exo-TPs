package com.pizzeria.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.pizzeria.cart.model.Cart;

public class LoginAction extends ActionSupport{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	        throws Exception {
	 
		/*
		 * Ajout d'une session pour gérer le Panier
		 */
		HttpSession session = request.getSession();
		
		String token = "valide";
		
		session.setAttribute("sessionToken", token);
		        
			return mapping.findForward("success");
		  
		}

}
