package com.pizzeria.customer.bo.impl;

import java.util.List;

import com.pizzeria.customer.bo.CustomerBo;
import com.pizzeria.customer.dao.CustomerDao;
import com.pizzeria.customer.model.Customer;
 
public class CustomerBoImpl implements CustomerBo{
 
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer){
		
		customerDao.addCustomer(customer);

	}
	
	public List<Customer> findAllCustomer(){
		
		return customerDao.findAllCustomer();
	}
 
}