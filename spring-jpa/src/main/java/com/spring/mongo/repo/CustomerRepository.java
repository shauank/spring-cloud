package com.spring.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.entity.Customer;

public interface CustomerRepository  extends MongoRepository<Customer, Long>, CustomCustomerRepository{
	
	public List<Customer> findByLastName(String name);

}
