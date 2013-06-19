package com.pizzeria.pizza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pizzeria.pizza.dao.PizzaDao;
import com.pizzeria.pizza.model.Pizza;

public class PizzaDaoImpl extends HibernateDaoSupport implements PizzaDao{

	public void addPizza(Pizza pizza) {
		
		getHibernateTemplate().save(pizza);
		
	}

	@SuppressWarnings("unchecked")
	public List<Pizza> findAllPizza() {
		
		
		return getHibernateTemplate().find("from Pizza");
	}

}
