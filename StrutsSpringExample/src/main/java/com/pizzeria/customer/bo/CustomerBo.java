package com.pizzeria.customer.bo;

import java.util.List;

import com.pizzeria.customer.model.Customer;
 
public interface CustomerBo{
 
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
 
}