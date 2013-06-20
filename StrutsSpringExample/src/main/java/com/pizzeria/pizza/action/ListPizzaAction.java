package com.pizzeria.pizza.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.web.struts.ActionSupport;


import com.pizzeria.cart.model.Cart;
import com.pizzeria.pizza.bo.PizzaBo;
import com.pizzeria.pizza.model.Pizza;

public class ListPizzaAction extends ActionSupport {
	
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	        throws Exception {
		
		
		PizzaBo pizzaBo =
				(PizzaBo) getWebApplicationContext().getBean("pizzaBo");
			
			DynaActionForm dynaPizzaListForm = (DynaActionForm)form;
			
			List<Pizza> list = pizzaBo.findAllPizza();
			
			dynaPizzaListForm.set("pizzaList", list);
			
			/*
			 * Ajout d'une session pour gérer le Panier
			 */
			HttpSession session = request.getSession();
			Cart cart = new Cart();
			String token = "invalide";
			
			session.setAttribute("sessionCart", cart);
			if (session.getAttribute("sessionToken") != null && ((String) session.getAttribute("sessionToken")).equals("valide")){		
				
			}else {
				session.setAttribute("sessionToken", token);
			}
		
		
		return mapping.findForward("success");
	}

}
