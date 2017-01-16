package com.spring.cassandra.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.spring.entity.cassandra.Products;

public class ProductsRepositoryImpl implements ProductsRepositoryCustom{

	
	@Autowired
	private CassandraTemplate cassandraTemplate;
	
	@Override
	public List<Products> selectAll() {
		return cassandraTemplate.selectAll(Products.class);
	}

}
