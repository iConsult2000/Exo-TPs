package com.pizzeria.customer.dao.impl;

import java.util.Date;
import java.util.List;

import com.pizzeria.customer.dao.CustomerDao;
import com.pizzeria.customer.model.Customer;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
	
	public void addCustomer(Customer customer){
		
		customer.setCreatedDate(new Date());
		getHibernateTemplate().save(customer);

	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer(){
		
		return getHibernateTemplate().find("from Customer");
		
	}
}