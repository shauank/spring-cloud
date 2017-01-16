package com.spring;

import java.util.Arrays;
import java.util.List;


import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.spring.cassandra.repo.ProductsRepository;
import com.spring.entity.cassandra.Products;
import com.spring.entity.mongo.Customer;
import com.spring.mongo.repo.CustomerRepository;

@SpringBootApplication
public class SpringJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
}

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

@RestController
@RequestMapping("/product")
class ProductController {

	@Autowired
	private ProductsRepository productRepository;

	/*@Autowired
	private CassandraTemplate cassandraTemplate;*/

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Products createCustomer(@RequestBody Products product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Products> getAllProducts() {
		return this.productRepository.selectAll();
	}

}

@Configuration
@EnableMongoRepositories(basePackages = "com.spring.mongo.repo")
@EntityScan(basePackages = "com.spring.entity.mongo")
class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "customer-db";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoCredential credential = MongoCredential.createCredential("rootCustomer", "customer-db",
				"root".toCharArray());

		ServerAddress address = new ServerAddress("localhost");
		MongoClient client = new MongoClient(Arrays.asList(address), Arrays.asList(credential));
		return client;
	}

}
