package com.spring.mongo.repo;

import java.util.List;

import com.spring.mongo.entity.Customer;

public interface CustomCustomerRepository {
	
	public List<Customer> getAllCustomers();

}
