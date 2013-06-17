package com.pizzeria.customer.dao;

import java.util.List;

import com.pizzeria.customer.model.Customer;
 
public interface CustomerDao{
 
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
 
}