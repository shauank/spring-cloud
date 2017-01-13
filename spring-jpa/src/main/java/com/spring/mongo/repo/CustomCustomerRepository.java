package com.spring.mongo.repo;

import java.util.List;

import com.spring.entity.mongo.Customer;

public interface CustomCustomerRepository {
	
	public List<Customer> getAllCustomers();

}
