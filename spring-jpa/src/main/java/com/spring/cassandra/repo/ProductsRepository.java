package com.spring.cassandra.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.spring.cassandra.entity.Products;

public interface ProductsRepository extends CassandraRepository<Products>, ProductsRepositoryCustom{
	public Products findByName(String name);
}
