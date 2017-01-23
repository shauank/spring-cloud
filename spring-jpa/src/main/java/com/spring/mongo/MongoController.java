package com.spring.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.spring.mongo.entity.Customer;
import com.spring.mongo.repo.CustomerRepository;

@RestController
@RequestMapping("/customer")
class MongoController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	@Deprecated
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.POST)
	public boolean updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
		Query query = new Query(where("id").is(customerId));

		DBObject dbObj = new BasicDBObject();
		this.mongoTemplate.getConverter().write(customer, dbObj);

		Update update = Update.fromDBObject(dbObj, "_id");
		WriteResult updateFirst = this.mongoTemplate.upsert(query, update, Customer.class);

		return updateFirst.isUpdateOfExisting();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}
}
