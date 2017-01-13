package com.spring.cassandra.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.spring.entity.cassandra.Products;

public interface ProductRepository extends CassandraRepository<Products>, CustomProductRepository{
	
	public List<Products> getAllProducts();
}
