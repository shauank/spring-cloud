package com.spring.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cassandra.entity.Products;
import com.spring.cassandra.repo.ProductsRepository;

@RestController
@RequestMapping("/product")
@ComponentScan(basePackages={"com.spring.cassandra"})
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
