package com.spring.cassandra.repo;

import java.util.List;

import com.spring.cassandra.entity.Products;

public interface ProductsRepositoryCustom {
	public List<Products> selectAll();
}
