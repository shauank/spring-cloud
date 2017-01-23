package com.spring.mongo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.spring.mongo.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomCustomerRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Customer> getAllCustomers() {
		return mongoTemplate.findAll(Customer.class);
	}

}
